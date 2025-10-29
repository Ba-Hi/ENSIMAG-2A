import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Point> positionsBalls;
    private List<Point> initialPositions;

    public Balls() {
        this.positionsBalls = new ArrayList<>();
        this.initialPositions = new ArrayList<>();

        Point p1 = new Point(250, 250);
        Point p2 = new Point(250, 400);
        Point p3 = new Point(0, 200);

        this.positionsBalls.add(p1);
        this.positionsBalls.add(p2);
        this.positionsBalls.add(p3);

        this.initialPositions.add((Point) p1.clone()); // gérer le prb de réference !
        this.initialPositions.add((Point) p2.clone());
        this.initialPositions.add((Point) p3.clone());
    }

    void translate(int dx, int dy){
        for (Point p : this.positionsBalls){
            p.translate(dx, dy);
        }
    }

    void reInit(){
        this.positionsBalls.clear();
        for (Point p : this.initialPositions){
            this.positionsBalls.add((Point) p.clone());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Positions des balles :\n");
        int index = 1;
        for (Point p : this.positionsBalls) {
            sb.append("Balle ").append(index++)
                    .append(" : (x=").append(p.x)
                    .append(", y=").append(p.y).append(")\n");
        }
        return sb.toString();
    }

    public List<Point> getBalls(){
        return positionsBalls;
    }

}
