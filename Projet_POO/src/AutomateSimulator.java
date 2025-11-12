import gui.GUISimulator;
import gui.Simulable;

public abstract class AutomateSimulator implements Simulable {
    protected AutomateCellulaire automate; // Lien vers le modèle (polymorphisme)
    protected GUISimulator gui;
    
    public AutomateSimulator(GUISimulator gui, AutomateCellulaire automate) {
        this.gui = gui;
        this.automate = automate;
    }
    
    public abstract void drawCases();

    public void next() {
        this.automate.evolve();
        drawCases();
        System.out.println(this.automate.toString());
    }

    public void restart() {
        this.automate.reInit();
        drawCases();
        System.out.println(this.automate.toString());
    }
}