import gui.GUISimulator;
import gui.Simulable;
import java.awt.Color;

public class TestBoidSimulator {
    public static void main(String[] args) {
        // création de la fenêtre GUI
        GUISimulator gui = new GUISimulator(500, 500, Color.BLACK);

        // création du simulateur avec 50 boids
        BoidSimulator sim = new BoidSimulator(gui, 50);

        // définition de l'interface Simulable pour contrôler le simulateur
        gui.setSimulable(new Simulable() {
            @Override
            public void next() {
                sim.next(); // mise à jour et affichage des boids
            }

            @Override
            public void restart() {
                // possibilité de réinitialiser si besoin
            }
        });
    }
}
