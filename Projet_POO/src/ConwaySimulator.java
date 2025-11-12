import gui.Simulable;
import gui.GUISimulator;
import java.awt.Color;
import java.awt.Point;

public class ConwaySimulator extends AutomateSimulator {
    private JeuDeLaVie cases; 


    public ConwaySimulator(GUISimulator gui, JeuDeLaVie cases) {
        super(gui, cases);
        this.cases = cases;
    }

    @Override
    public void drawCases(){
        gui.reset();
        for (Point p : cases.getPositions()){
            gui.addGraphicalElement(
                    new gui.Rectangle(p.x, p.y, Color .BLACK, Color .BLACK, cases.getTailleCellule())
            );
        }
}
}