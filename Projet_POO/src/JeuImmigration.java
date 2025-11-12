import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JeuImmigration extends AutomateCellulaire {
    private List<Integer> etats;    
    private List<Integer> initialEtats;
    private int nEtats; // propres au jeu de l'immigration

    public JeuImmigration(int nEtats) {
        super(500, 500, 10);
        this.nEtats = nEtats;
        this.etats = new ArrayList<>();
        this.initialEtats = new ArrayList<>();
        initialiserAleatoirement();
    }
    
    // Differente initialisations
    @Override
    public void reInit() {
        super.reInit(); // Réinitialise les positions
        this.etats.clear();
        for (int etat : this.initialEtats) {
            this.etats.add(etat);
        } // initialiser les états
    }


    @Override
    public void initialiserAleatoirement() {
        Random rand = new Random();
        for (int x = 0; x < largeurGrilleM; x += tailleCellule) {
            for (int y = 0; y < hauteurGrilleN; y += tailleCellule) {
                Point p = new Point(x, y);
                int etat = rand.nextInt(nEtats);
                positions.add(p);
                etats.add(etat);
                initialPositions.add((Point) p.clone());
                initialEtats.add(etat);
            }
        }
    }

    @Override
    public void evolve() {
        // Règle de l'Immigration : État k passe à k+1 (mod n) ssi 3 voisins ou plus sont à l'état k+1 [cite: 199]
        
        // NOTE: Le code de la classe mère 'compterVoisins' ne peut pas être réutilisé directement
        // car il ne compte que les Point dans une liste. 
        // Ici, nous avons besoin de l'état du voisin, nous devons donc réimplémenter la boucle de voisinage.
        
        List<Integer> anciensEtats = new ArrayList<>(etats);
        List<Integer> nouveauxEtats = new ArrayList<>(etats.size());

        for (int i = 0; i < positions.size(); i++) {
            Point p = positions.get(i);
            int etatActuel = anciensEtats.get(i);
            int etatSuivant = (etatActuel + 1) % nEtats; // État vers lequel on "immigre" [cite: 199]

            int voisinsEtatSuivant = 0;

            for (int dx = -tailleCellule; dx <= tailleCellule; dx += tailleCellule) {
                for (int dy = -tailleCellule; dy <= tailleCellule; dy += tailleCellule) {
                    if (dx == 0 && dy == 0) continue;

                    int nx = (p.x + dx + largeurGrilleM) % largeurGrilleM;
                    int ny = (p.y + dy + hauteurGrilleN) % hauteurGrilleN;

                    for (int j = 0; j < positions.size(); j++) {
                        Point v = positions.get(j);
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

        etats = nouveauxEtats;
    }

    public List<Integer> getEtats() {
        return etats;
    }
    
    public int getNEtats() {
        return nEtats;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("États des cellules (Jeu de l'Immigration) :\n");
        for (int i = 0; i < positions.size(); i++) {
            Point p = positions.get(i);
            int etat = etats.get(i);
            sb.append("(").append(p.x).append(", ").append(p.y)
                    .append(") → état ").append(etat).append("\n");
        }
        return sb.toString();
    }
}