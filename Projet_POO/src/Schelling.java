import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.awt.Point;

public class Schelling extends AutomateCellulaire {
    private int nombreCouleurs;
    private int seuilK;
    private List<Point> casesVacantes;
    private int[][] grille;

    public Schelling(int nombreCouleurs, int seuilK) {
        super(500, 500, 10);
        this.nombreCouleurs = nombreCouleurs;
        this.seuilK = seuilK;
        this.casesVacantes = new ArrayList<>();
        this.grille = new int[hauteurGrilleN / tailleCellule][largeurGrilleM / tailleCellule];
        initialiserAleatoirement();
    }

    @Override
    public void initialiserAleatoirement() {
        for (int i=0; i < hauteurGrilleN / tailleCellule; i++) {
            for (int j=0; j < largeurGrilleM / tailleCellule; j++) {
                Random rand = new Random();
                if (rand.nextDouble() < 0.1) {
                    grille[i][j] = 0;
                    casesVacantes.add(new Point(i, j));
                }
                else {
                    grille[i][j] = 1 + rand.nextInt(nombreCouleurs);
                    positions.add(new Point(i * tailleCellule, j * tailleCellule));
                }
            }
        }
    }

    @Override
    public void evolve() {
        Random rand = new Random();
        for (int i=0; i<hauteurGrilleN / tailleCellule; i++) {
            for (int j=0; j<largeurGrilleM / tailleCellule; j++) {
                if (grille[i][j] != 0) {
                    int voisinsSimilaires = compterVoisinsCouleurs(i, j);
                    if (8 - voisinsSimilaires > seuilK) {
                        int indexVacant = rand.nextInt(casesVacantes.size());
                        Point nouvellePosition = casesVacantes.get(indexVacant);
                        
                        // Mise à jour de la liste des cases vacantes
                        casesVacantes.set(indexVacant, new Point(i, j)); // l’ancienne devient vide

                        // Mise à jour de la liste des positions (pour affichage)
                        positions.remove(new Point(i * tailleCellule, j * tailleCellule));
                        positions.add(new Point(nouvellePosition.x * tailleCellule, nouvellePosition.y * tailleCellule));
                        
                        // Mise à jour de la grille
                        grille[nouvellePosition.x][nouvellePosition.y] = grille[i][j];
                        grille[i][j] = 0;
                    }
                }

            }
        }
    }

    protected int compterVoisinsCouleurs(int cx, int cy) {
        int voisinsSimilaires = 0;
        int couleurCourante = grille[cx][cy];

        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx == 0 && dy == 0) continue;

                int nx = (cx + dx + hauteurGrilleN / tailleCellule) % (hauteurGrilleN / tailleCellule);
                int ny = (cy + dy + largeurGrilleM / tailleCellule) % (largeurGrilleM / tailleCellule);

                if (grille[nx][ny] == couleurCourante) {
                    voisinsSimilaires++;
                }
            }
        }
        return voisinsSimilaires;
    }

    public int[][] getGrille() {
        return this.grille;
    }

    public int getNombreCouleurs() {
        return this.nombreCouleurs;
    }

}