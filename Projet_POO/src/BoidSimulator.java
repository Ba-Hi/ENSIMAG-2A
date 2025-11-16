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
            boids.add(new Boid(Math.random()*500, Math.random()*500));
        }
    }

    public void next() {
        gui.reset();
        for (Boid b : boids) {
            b.move(boids);
            drawBoid(b);
            b.update();
        }
    }

    private void drawBoid(Boid b) {
        Vector2D pos = b.getPosition();
        Vector2D vel = b.getVelocity();

        double angle = Math.atan2(vel.y, vel.x);

        // taille du triangle
        int size = 10;

        // coordonnées du triangle
        int x1 = (int) (pos.x + size * Math.cos(angle));
        int y1 = (int) (pos.y + size * Math.sin(angle));
        int x2 = (int) (pos.x + size * Math.cos(angle + 2.5));
        int y2 = (int) (pos.y + size * Math.sin(angle + 2.5));
        int x3 = (int) (pos.x + size * Math.cos(angle - 2.5));
        int y3 = (int) (pos.y + size * Math.sin(angle - 2.5));

        Polygon triangle = new Polygon();
        triangle.addPoint(x1, y1);
        triangle.addPoint(x2, y2);
        triangle.addPoint(x3, y3);

        gui.addGraphicalElement(new gui.Circle((int)pos.x, (int)pos.y, Color.BLUE, Color.BLUE, 10));

        // gui.addGraphicalElement(new gui.PolygonElement(triangle, Color.BLUE, Color.BLUE));
    }
}
