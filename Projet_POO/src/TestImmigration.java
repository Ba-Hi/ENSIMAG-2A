// Les classes gui.GUISimulator et java.awt.Color sont assumées disponibles
import gui.GUISimulator;
import java.awt.Color;

/**
 * Programme principal pour démarrer l'interface graphique de simulation
 * et y associer notre BallsSimulator.
 */
public class TestImmigration {

    public static void main(String[] args) {
        // Création de la fenêtre de simulation (taille et couleur de fond)
        // Les dimensions sont arbitraires, ici 500x500 sur fond noir.
        // NOTE: L'import 'gui.GUISimulator' nécessite d'avoir 'gui.jar' dans le classpath.
        GUISimulator gui = new GUISimulator(500, 500, Color.WHITE);

        // Création de l'instance du simulateur
        ImmigrationSimulator simulator = new ImmigrationSimulator(gui, 5);

        // Association du simulateur à l'interface graphique
        // BallsSimulator implémente Simulable, ce qui est attendu par setSimulable()
        gui.setSimulable(simulator);
    }
}
