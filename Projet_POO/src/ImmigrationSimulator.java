import gui.Simulable;
import gui.GUISimulator;
import java.awt.Color;
import java.awt.Point;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class ImmigrationSimulator extends AutomateSimulator {
    private JeuImmigration cases;
    private List<Color> couleurs;

    public ImmigrationSimulator(GUISimulator gui, JeuImmigration cases) {
        super(gui, cases);
        this.cases = cases;
        this.couleurs = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < cases.getNEtats(); i++) {
            Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            this.couleurs.add(c);
        }
    }
    @Override
    public void drawCases(){
        gui.reset();
        for (int i = 0; i < cases.getPositions().size(); i++) {
            Point p = cases.getPositions().get(i);
            int etat = cases.getEtats().get(i);       // état de la cellule
            Color couleurCellule = this.couleurs.get(etat); // couleur associée à l’état

            gui.addGraphicalElement(
                new gui.Rectangle(p.x, p.y, couleurCellule, couleurCellule, 10)
            );
        }
    }
}