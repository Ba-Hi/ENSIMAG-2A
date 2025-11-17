




import java.util.List;

import java.util.ArrayList;


public class Boid {
    private Vector2D position;
    private Vector2D vitesse;
    private Vector2D acceleration;
    private double maxVitesse = 4;
    private double maxForce = 0.1;

    public Boid(Vector2D pos, Vector2D vel) {
        this.position = pos;
        this.vitesse = vel;
        this.acceleration = new Vector2D(0, 0);
    
    }

    public void applyForce(Vector2D force) {
        acceleration = acceleration.add(force); // a_n+1 = 0 + F/m (m=1)
    }

    public void update() {
        vitesse = vitesse.add(acceleration); // v_n+1 = v_n + a_n
        vitesse = vitesse.limit(maxVitesse); // limiter la vitesse
        position = position.add(vitesse); // x_n+1 = x_n + v_n
        acceleration = new Vector2D(0, 0); // réinitialiser l'accélération, à chaque itération
    }

    public Vector2D cohesion(List<Boid> voisins) {
        // Calcul du centre de masse G : OG = (1/N) * Σ OBi
        Vector2D center = new Vector2D(0, 0);
        int count = 0;
        for (Boid other : voisins) {
            center = center.add(other.position);
            count++;
        }
        if (count == 0) return new Vector2D(0, 0);
        center = center.divide(count);

        // Vecteur désiré : de la position actuelle vers le centre
        // AG = F_cohesion = center - position = position_G - position_Boid
        Vector2D desired = center.subtract(this.position);
        desired = desired.normalize().multiply(maxVitesse); // vitesse désirée à la direction de G
        Vector2D steer = desired.subtract(this.vitesse); // force de steering : difference entre vitesse désirée et actuelle
        
        return steer.limit(maxForce);
    }


    public Vector2D alignment(List<Boid> voisins) {
        Vector2D avgVel = new Vector2D(0, 0); // moyenne des vitesses
        int count = 0;
        for (Boid other : voisins) {
            avgVel = avgVel.add(other.vitesse);
            count++;
        }
        if (count == 0) return new Vector2D(0, 0);
        avgVel = avgVel.divide(count);
        
        avgVel = avgVel.normalize().multiply(maxVitesse);
        Vector2D steer = avgVel.subtract(this.vitesse);
        return steer.limit(maxForce);
    }

    public Vector2D separation(List<Boid> voisins, double desiredSeparation) {
        Vector2D steer = new Vector2D(0, 0);
        int count = 0;
        for (Boid other : voisins) {
            double d = this.position.distance(other.position);
            if (d > 0 && d < desiredSeparation) { // proche enough
                Vector2D diff = this.position.subtract(other.position);
                diff = diff.normalize();
                diff = diff.divide(d);  // plus proche donc plus forte répulsion, norme = 1/d
                steer = steer.add(diff);
                count++;
            }
        }
        if (count == 0) return new Vector2D(0, 0);
        steer = steer.divide(count);
        steer = steer.normalize().multiply(maxVitesse);
        steer = steer.subtract(this.vitesse);
        return steer.limit(maxForce);
    }

    public void move(List<Boid> allBoids) {
        double neighRadius = 50; // à ajuster
        double sepDist = 25;
        List<Boid> neighbors = new ArrayList<>();
        for (Boid other : allBoids) {
            if (other != this && this.position.distance(other.position) < neighRadius) {
                neighbors.add(other);
            }
        }

        Vector2D coh = cohesion(neighbors);
        Vector2D ali = alignment(neighbors);
        Vector2D sep = separation(neighbors, sepDist);

        // a mentionner dans le rapport !!
        coh = coh.multiply(1.0);
        ali = ali.multiply(1.0);
        sep = sep.multiply(1.5);

        applyForce(coh);
        applyForce(ali);
        applyForce(sep);
    }

    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getVelocity() {
        return vitesse;
    }

    public void bounce(double width, double height) {
        if (position.x < 0) {
            position.x = 0;
            vitesse.x = -vitesse.x;
        } 
        else if (position.x > width) {
            position.x = width;
            vitesse.x = -vitesse.x;
        }

        // Bords haut et bas
        if (position.y < 0) {
            position.y = 0;
            vitesse.y = -vitesse.y;
        } 
        else if (position.y > height) {
            position.y = height;
            vitesse.y = -vitesse.y;
        }
    }


}


class Vector2D {
    public double x, y;

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector2D add(Vector2D v) {
        return new Vector2D(this.x + v.x, this.y + v.y);
    }

    public Vector2D subtract(Vector2D v) {
        return new Vector2D(this.x - v.x, this.y - v.y);
    }

    public Vector2D multiply(double k) {
        return new Vector2D(this.x * k, this.y * k);
    }

    public Vector2D divide(double k) {
        return new Vector2D(this.x / k, this.y / k);
    }

    public double magnitude() {
        return Math.sqrt(x*x + y*y);
    }

    public Vector2D normalize() {
        double mag = magnitude();
        if (mag == 0) return new Vector2D(0,0);
        return divide(mag);
    }

    public double distance(Vector2D v) {
        double dx = this.x - v.x;
        double dy = this.y - v.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public Vector2D limit(double max) {
        if (magnitude() > max) return normalize().multiply(max);
        return this;
    }
}
