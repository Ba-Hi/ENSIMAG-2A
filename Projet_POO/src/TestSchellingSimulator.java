import gui.GUISimulator;
import java.awt.Color;

public class TestSchellingSimulator {
    public static void main(String[] args) {
        GUISimulator gui = new GUISimulator(500, 500, Color.WHITE);
        Schelling model = new Schelling(5, 4);
        SchellingSimulator simulator = new SchellingSimulator(gui, model);
        simulator.drawCases();
        gui.setSimulable(simulator);
    }
}
