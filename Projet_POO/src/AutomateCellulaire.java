import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AutomateCellulaire {
    protected List<Point> positions;
    protected List<Point> initialPositions;
    protected int hauteurGrilleN = 500;
    protected int largeurGrilleM = 500;
    protected int tailleCellule = 10;


    public AutomateCellulaire(int hauteur, int largeur, int taille) {
        this.positions = new ArrayList<>();
        this.initialPositions = new ArrayList<>();
        this.hauteurGrilleN = hauteur;
        this.largeurGrilleM = largeur;
        this.tailleCellule = taille;
    }

    public abstract void initialiserAleatoirement();

    public abstract void evolve();

    public void reInit() {
        this.positions.clear();

        for (Point p : this.initialPositions) {
            this.positions.add((Point) p.clone());
        }
    }


    protected int compterVoisins(int cx, int cy, List<Point> listeReference) {
        int voisins = 0;

        for (int dx = -tailleCellule; dx <= tailleCellule; dx += tailleCellule) {
            for (int dy = -tailleCellule; dy <= tailleCellule; dy += tailleCellule) {
                if (dx == 0 && dy == 0) continue; // Pas soi-même

                int nx = (cx + dx + largeurGrilleM) % largeurGrilleM;
                int ny = (cy + dy + hauteurGrilleN) % hauteurGrilleN;

 
                for (Point p : listeReference) {
                    if (p.x == nx && p.y == ny) {
                        voisins++;
                        break;
                    }
                }
            }
        }
        return voisins;
    }

    public List<Point> getPositions() {
        return this.positions;
    }

    public int getHauteurGrilleN() {
        return hauteurGrilleN;
    }

    public int getLargeurGrilleM() {
        return largeurGrilleM;
    }

    public int getTailleCellule() {
        return tailleCellule;
    }
}