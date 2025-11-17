import gui.GUISimulator;
import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.awt.Polygon;

public class BoidSimulator {
    private GUISimulator gui;
    private List<Boid> boids;

    public BoidSimulator(GUISimulator gui, int n) {
        this.gui = gui;
        this.boids = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            boids.add(new Boid(
                new Vector2D(Math.random()*500, Math.random()*500),
                new Vector2D(Math.random()*2 - 1, Math.random()*2 - 1)
            ));
        }
    }

    public void next() {
        gui.reset();
        for (Boid b : boids) {
            b.move(boids);
            b.update();
            b.bounce(500, 500);
            drawBoid(b);

        }
    }

 private void drawBoid(Boid b) {
    Vector2D pos = b.getPosition();
    Vector2D vel = b.getVelocity();

    double angle = Math.atan2(vel.y, vel.x);

    int size = 10;

    // Cercle principal
    gui.addGraphicalElement(new gui.Oval((int)pos.x, (int)pos.y, Color.BLUE, Color.BLUE, size));

    // Indicateur de direction : un petit cercle devant
    int hx = (int)(pos.x + size * Math.cos(angle));
    int hy = (int)(pos.y + size * Math.sin(angle));
    gui.addGraphicalElement(new gui.Oval(hx, hy, Color.RED, Color.RED, size/3));
}

}
