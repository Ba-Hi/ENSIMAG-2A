import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JeuDeLaVie extends AutomateCellulaire {    
    public JeuDeLaVie() {
        super(500, 500, 10);
        initialiserAleatoirement();
    }

    @Override
    public void initialiserAleatoirement() {
        Random rand = new Random();
        int nbCellulesVivantes = rand.nextInt(hauteurGrilleN/tailleCellule * largeurGrilleM/tailleCellule) + 1;
        for (int i = 0; i < nbCellulesVivantes; i += 1) {
            int x = rand.nextInt(largeurGrilleM / tailleCellule) * tailleCellule;
            int y = rand.nextInt(hauteurGrilleN / tailleCellule) * tailleCellule;
            Point p = new Point(x, y);
            positions.add(p);
            initialPositions.add((Point) p.clone());
        }
    }

    @Override
    public void evolve() {
        // Chaque cellule de la grille peut prendre deux états : vivant ou mort.
        // Une cellule morte possédant exactement trois voisines (sur huit) vivantes devient vivante (elle naît).
        // Une cellule vivante possédant deux ou trois voisines (sur huit) vivantes le reste, sinon elle meurt.

        List<Point> ancienneListe = new ArrayList<>();

        for (Point p : positions) {
            ancienneListe.add(new Point(p)); 
        }

        List<Point> nouvelleListe = new ArrayList<>();

        for (int x = 0; x < largeurGrilleM; x += tailleCellule) {
            for (int y = 0; y < hauteurGrilleN; y += tailleCellule) {

                int voisins = compterVoisins(x, y, ancienneListe);

                boolean vivante = false;
                for (Point p : ancienneListe) {
                    if (p.x == x && p.y == y) {
                        vivante = true;
                        break;
                    }
                }

                if (vivante) {
                    if (voisins == 2 || voisins == 3) {
                        nouvelleListe.add(new Point(x, y));
                    }
                } else { 
                    if (voisins == 3) {
                        nouvelleListe.add(new Point(x, y));
                    }
                }
            }
        }

        positions = nouvelleListe;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder("Positions des cellules vivantes (Jeu de la Vie) :\n");
        int index = 1;
        for (Point p : this.positions) {
            sb.append("Case ").append(index++)
                    .append(" : (x=").append(p.x)
                    .append(", y=").append(p.y).append(")\n");
        }
        return sb.toString();
    }
}