import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cases {
    private List<Point> positionsCases; // Les cellules vivantes
    private List<Point> initialPositions;
    private int hauteurGrilleN;
    private int largeurGrilleM;
    private int tailleCellule = 10;

    public Cases() {
        this.positionsCases = new ArrayList<>();
        this.initialPositions = new ArrayList<>();
        this.hauteurGrilleN = 500;
        this.largeurGrilleM = 500;

        initialiserAleatoirement();
    }

    public void initialiserAleatoirement(){
        Random rand = new Random();
        int nbCellulesVivantes = rand.nextInt(hauteurGrilleN/tailleCellule * largeurGrilleM/tailleCellule) + 1;
        for (int i = 0; i < nbCellulesVivantes; i += 1) {
            int x = (rand.nextInt(largeurGrilleM/10 + 1)) * 10;
            int y = (rand.nextInt(hauteurGrilleN/10 + 1)) * 10;
            Point p = new Point(x, y);
            positionsCases.add(p);
            initialPositions.add((Point) p.clone());
        }
    }


    void addCase(int dx, int dy){
        positionsCases.add(new Point(dx, dy));
    }

    void reInit(){
        this.positionsCases.clear();
        for (Point p : this.initialPositions){
            this.positionsCases.add((Point) p.clone());
        }
    }

    public void evolve() {
      
        List<Point> ancienneListe = new ArrayList<>();
        for (Point p : positionsCases) {
            ancienneListe.add(new Point(p)); // copie
        }

        List<Point> nouvelleListe = new ArrayList<>();

        for (int x = 0; x < largeurGrilleM; x+=10) {
            for (int y = 0; y < hauteurGrilleN; y+=10) {
                int voisins = 0;

                for (int dx = -10; dx <= 10; dx+=10) {
                    for (int dy = -10; dy <= 10; dy+=10) {
                        if (dx == 0 && dy == 0) continue; // pas soi-même

                        int nx = (x + dx + largeurGrilleM) % largeurGrilleM;
                        int ny = (y + dy + hauteurGrilleN) % hauteurGrilleN;

                        for (Point p : ancienneListe) {
                            if (p.x == nx && p.y == ny) {
                                voisins++;
                                break;
                            }
                        }
                    }
                }

                // Vérifier si (x, y) est vivante actuellement
                boolean vivante = false;
                for (Point p : ancienneListe) {
                    if (p.x == x && p.y == y) {
                        vivante = true;
                        break;
                    }
                }

                // Appliquer les règles de Conway
                if ((vivante && (voisins == 2 || voisins == 3)) || (!vivante && voisins == 3)) {
                    nouvelleListe.add(new Point(x, y));
                }
            }
        }

        // Remplacer l’ancienne génération
        positionsCases = nouvelleListe;
        System.out.println(positionsCases.toString());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Positions des cases :\n");
        int index = 1;
        for (Point p : this.positionsCases) {
            sb.append("Case ").append(index++)
                    .append(" : (x=").append(p.x)
                    .append(", y=").append(p.y).append(")\n");
        }
        return sb.toString();
    }

    public List<Point> getCases(){
        return positionsCases;
    }

}
