import java.awt.Color;
import java.awt.Point;
import java.util.*;
import gui.GUISimulator;

public class SchellingSimulator extends AutomateSimulator {
    private Schelling s;
    private List<Color> palette;

    public SchellingSimulator(GUISimulator gui, Schelling schelling) {
        super(gui, schelling);
        this.s = schelling;
        genererPalette(schelling.getNombreCouleurs());
    }

    @Override
    public void drawCases() {
        gui.reset();
        
        int taille = s.getTailleCellule();
        int[][] grille = s.getGrille();

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[0].length; j++) {
                int couleur = grille[i][j];
                Color c = (couleur == 0) ? Color.LIGHT_GRAY : palette.get(couleur - 1);
                gui.addGraphicalElement(
                    new gui.Rectangle(j * taille, i * taille, c, c, taille)
                );
            }
        }
    }

    private void genererPalette(int n) {
        palette = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            palette.add(c);
        }
    }
}
