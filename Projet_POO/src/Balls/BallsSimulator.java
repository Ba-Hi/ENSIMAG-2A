import gui.Simulable;
import gui.GUISimulator;
import java.awt.Color;
import java.awt.Point;

public class BallsSimulator implements Simulable {
    private Balls balls;
    private GUISimulator gui;

    private int VX = 10;
    private int VY = 10;


    public BallsSimulator(GUISimulator gui) {
        this.balls = new Balls();
        this.gui = gui;
        drawBalls();
    }

    public void drawBalls(){
        gui.reset();
        for (Point p : balls.getBalls()){
            gui.addGraphicalElement(
                    new gui.Oval(p.x, p.y, Color .green, Color .green, 30)
            );
        }
    }

    @Override
    public void next() {
        this.balls.translate(VX, VY);
        List<Point> vitesses = new ArrayList<>();
        for (Point p : balls.getBalls()){
            Point vitesse = new Point(VX, VY);
            vitesses.add(vitesse);
            if (p.x <= 0 || p.x >= 500){ // touche bord gauche ou droite
                VX = - VX;
                p.y += VY;
                if (p.x > 500) p.x = 500;
                else if (p.x < 0) p.x = 0;

            }
            if (p.y <= 0 || p.y >= 500){ // touche bord supérieur ou inf
                VY = - VY;
                p.x += VX;
                if (p.y >= 500) p.y = 500;
                else if (p.y <= 0) p.y = 0;
            }
        }
        drawBalls();
        // Affichage du nouvel état dans la console (comme dans l'exemple de trace)
        System.out.println(this.balls.toString());
    }


    @Override
    public void restart() {
        this.balls.reInit();
        // Affichage de l'état réinitialisé
        System.out.println(this.balls.toString());
        drawBalls();
    }

}
