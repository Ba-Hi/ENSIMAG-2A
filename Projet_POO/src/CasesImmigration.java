import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CasesImmigration {
    private List<Point> positionsCases;      // positions de toutes les cellules
    private List<Integer> etatsCases;        // état de chaque cellule
    private List<Point> initialPositions;
    private List<Integer> initialEtats;
    private int hauteurGrilleN;
    private int largeurGrilleM;
    private int nEtats;
    private int tailleCellule = 10;

    public CasesImmigration(int nEtats) {
        this.positionsCases = new ArrayList<>();
        this.etatsCases = new ArrayList<>();
        this.initialPositions = new ArrayList<>();
        this.initialEtats = new ArrayList<>();
        this.hauteurGrilleN = 500;
        this.largeurGrilleM = 500;
        this.nEtats = nEtats;

        initialiserAleatoirement();
    }

    private void initialiserAleatoirement() {
        Random rand = new Random();
        for (int x = 0; x < largeurGrilleM; x += tailleCellule) {
            for (int y = 0; y < hauteurGrilleN; y += tailleCellule) {
                Point p = new Point(x, y);
                int etat = rand.nextInt(nEtats);
                positionsCases.add(p);
                etatsCases.add(etat);
                initialPositions.add((Point) p.clone());
                initialEtats.add(etat);
            }
        }
    }

    void reInit() {
        positionsCases.clear();
        etatsCases.clear();
        for (int i = 0; i < initialPositions.size(); i++) {
            positionsCases.add((Point) initialPositions.get(i).clone());
            etatsCases.add(initialEtats.get(i));
        }
    }

    public void evolve() {
        List<Integer> anciensEtats = new ArrayList<>(etatsCases);
        List<Integer> nouveauxEtats = new ArrayList<>(etatsCases.size());

        for (int i = 0; i < positionsCases.size(); i++) {
            Point p = positionsCases.get(i);
            int etatActuel = anciensEtats.get(i);
            int etatSuivant = (etatActuel + 1) % nEtats;

            int voisinsEtatSuivant = 0;

            for (int dx = -tailleCellule; dx <= tailleCellule; dx += tailleCellule) {
                for (int dy = -tailleCellule; dy <= tailleCellule; dy += tailleCellule) {
                    if (dx == 0 && dy == 0) continue;

                    int nx = (p.x + dx + largeurGrilleM) % largeurGrilleM;
                    int ny = (p.y + dy + hauteurGrilleN) % hauteurGrilleN;

                    // recherche de la cellule voisine
                    for (int j = 0; j < positionsCases.size(); j++) {
                        Point v = positionsCases.get(j);
                        if (v.x == nx && v.y == ny) {
                            if (anciensEtats.get(j) == etatSuivant) {
                                voisinsEtatSuivant++;
                            }
                            break;
                        }
                    }
                }
            }

            if (voisinsEtatSuivant >= 3) {
                nouveauxEtats.add(etatSuivant);
            } else {
                nouveauxEtats.add(etatActuel);
            }
        }

        etatsCases = nouveauxEtats;
    }

    public List<Point> getPositionsCases() {
        return positionsCases;
    }

    public List<Integer> getEtatsCases() {
        return etatsCases;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("États des cellules :\n");
        for (int i = 0; i < positionsCases.size(); i++) {
            Point p = positionsCases.get(i);
            int etat = etatsCases.get(i);
            sb.append("(").append(p.x).append(", ").append(p.y)
                    .append(") → état ").append(etat).append("\n");
        }
        return sb.toString();
    }

}