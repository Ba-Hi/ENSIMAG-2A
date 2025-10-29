import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cases {
    private List<Point> positionsCases; // Les cellules vivantes
    private List<Point> initialPositions;
    private int hauteurGrilleN;
    private int largeurGrilleM;

    public Cases() {
        this.positionsCases = new ArrayList<>();
        this.initialPositions = new ArrayList<>();
        this.hauteurGrilleN = 500;
        this.largeurGrilleM = 500;
        Random rand = new Random();
        Point p1 = new Point(
                (rand.nextInt(largeurGrilleM / 10) + 1) * 10,
                (rand.nextInt(hauteurGrilleN / 10) + 1) * 10
        );

        Point p2 = new Point(
                (rand.nextInt(largeurGrilleM / 10) + 1) * 10,
                (rand.nextInt(hauteurGrilleN / 10) + 1) * 10
        );

        Point p3 = new Point(
                (rand.nextInt(largeurGrilleM / 10) + 1) * 10,
                (rand.nextInt(hauteurGrilleN / 10) + 1) * 10
        );

        Point p4 = new Point(Math.min(p1.x + 10, largeurGrilleM), Math.min(p1.y + 10, hauteurGrilleN));
        Point p5 = new Point(Math.min(p1.x + 10, largeurGrilleM), p1.y);



        this.positionsCases.add(p1);
        this.positionsCases.add(p2);
        this.positionsCases.add(p3);
        this.positionsCases.add(p4);
        this.positionsCases.add(p5);

        this.initialPositions.add((Point) p1.clone()); // gérer le prb de réference !
        this.initialPositions.add((Point) p2.clone());
        this.initialPositions.add((Point) p3.clone());
        this.initialPositions.add((Point) p4.clone());
        this.initialPositions.add((Point) p5.clone());
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
        // Chaque cellule de la grille peut prendre deux états : vivant ou mort.
        // Une cellule morte possédant exactement trois voisines (sur huit) vivantes devient vivante (elle naît).
        // Une cellule vivante possédant deux ou trois voisines (sur huit) vivantes le reste, sinon elle meurt.

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
