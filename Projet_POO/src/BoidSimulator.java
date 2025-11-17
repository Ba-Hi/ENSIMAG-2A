import gui.GUISimulator;
import gui.Simulable;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class BoidSimulator implements Simulable {
    private GUISimulator gui;
    private List<Boid> boids;
    private List<Boid> initBoids;

    public BoidSimulator(GUISimulator gui, int n) {
        this.gui = gui;
        this.boids = new ArrayList<>();
        this.initBoids = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Boid bird = new Boid(
                new Vector2D(Math.random()*500, Math.random()*500),
                new Vector2D(Math.random()*2 - 1, Math.random()*2 - 1)
            );
            boids.add(bird);
            initBoids.add(new Boid(bird));
            drawBoid(bird);
        }
    }

    @Override
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

        gui.addGraphicalElement(new gui.Oval((int)pos.x, (int)pos.y, Color.BLUE, Color.BLUE, size));

        // Indicateur de direction
        int hx = (int)(pos.x + size * Math.cos(angle));
        int hy = (int)(pos.y + size * Math.sin(angle));
        gui.addGraphicalElement(new gui.Oval(hx, hy, Color.RED, Color.RED, size/3));
    }

    public void drawFlock() {
        gui.reset();
        for (Boid b : boids) {
            drawBoid(b);
        }
    }

    @Override
    public void restart(){
        gui.reset();
        boids.clear();
        for (Boid b : initBoids) {
            boids.add(new Boid(b));
            drawBoid(b);
        }
    }    
}
