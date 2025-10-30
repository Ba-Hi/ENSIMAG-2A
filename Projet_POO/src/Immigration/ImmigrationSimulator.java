import gui.Simulable;
import gui.GUISimulator;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ImmigrationSimulator implements Simulable {
    private CasesImmigration cases;
    private GUISimulator gui;
    private int nEtats;
    private List<Color> couleurs;


    public ImmigrationSimulator(GUISimulator gui, int nEtat) {
        this.nEtats = nEtat;
        this.cases = new CasesImmigration(nEtats);
        this.gui = gui;
        this.couleurs = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < nEtat; i++) {
            Color c = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
            this.couleurs.add(c);
        }
        drawCases();
    }

    public void drawCases(){
        gui.reset();
        for (int i = 0; i < cases.getPositionsCases().size(); i++) {
            Point p = cases.getPositionsCases().get(i);
            int etat = cases.getEtatsCases().get(i);       // état de la cellule
            Color couleurCellule = this.couleurs.get(etat); // couleur associée à l’état

            gui.addGraphicalElement(
                new gui.Rectangle(p.x, p.y, couleurCellule, couleurCellule, 10)
            );
        }
    }

    @Override
    public void next() {
        this.cases.evolve();
        drawCases();
        System.out.println(this.cases.toString());
    }


    @Override
    public void restart() {
        this.cases.reInit();
        // Affichage de l'état réinitialisé
        System.out.println(this.cases.toString());
        drawCases();
    }

}