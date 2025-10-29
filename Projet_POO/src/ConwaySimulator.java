import gui.Simulable;
import gui.GUISimulator;
import java.awt.Color;
import java.awt.Point;

public class ConwaySimulator implements Simulable {
    private Cases cases;
    private GUISimulator gui;

    public ConwaySimulator(GUISimulator gui) {
        this.cases = new Cases();
        this.gui = gui;
        drawCases();
    }

    public void drawCases(){
        gui.reset();
        for (Point p : cases.getCases()){
            gui.addGraphicalElement(
                    new gui.Rectangle(p.x, p.y, Color .green, Color .green, 10)
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