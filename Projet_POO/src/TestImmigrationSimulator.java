// Les classes gui.GUISimulator et java.awt.Color sont assumées disponibles
import gui.GUISimulator;
import java.awt.Color;


public class TestImmigrationSimulator {

    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(500, 500, Color.WHITE);
        JeuImmigration cases = new JeuImmigration(5);

        // Création de l'instance du simulateur
        ImmigrationSimulator simulator = new ImmigrationSimulator(gui, cases);
        simulator.drawCases();
        // Association du simulateur à l'interface graphique
        // BallsSimulator implémente Simulable, ce qui est attendu par setSimulable()
        gui.setSimulable(simulator);

        System.out.println("\n--- GUI de BallsSimulator démarré ---");
        System.out.println("Les méthodes next() et restart() seront appelées par l'interface.");
        System.out.println("Vérifiez la console lors des clics sur 'Suivant' ou 'Début' pour la trace.");
    }
}
