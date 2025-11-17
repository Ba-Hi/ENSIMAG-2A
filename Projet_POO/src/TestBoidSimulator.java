import gui.GUISimulator;
import java.awt.Color;

public class TestBoidSimulator {
    public static void main(String[] args) {

        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);

        // création du simulateur avec 50 boids
        BoidSimulator sim = new BoidSimulator(gui, 50);

        // définition de l'interface Simulable pour contrôler le simulateur
        gui.setSimulable(sim);
    }
}
