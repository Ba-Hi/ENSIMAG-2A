import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Point> positions;
    private List<Point> initialPositions;

    public Balls() {
        this.positions = new ArrayList<>();
        this.initialPositions = new ArrayList<>();

        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 1);
        Point p3 = new Point(5, 2);

        this.positions.add(p1);
        this.positions.add(p2);
        this.positions.add(p3);

        this.initialPositions.add((Point) p1.clone()); // gérer le prb de réference !
        this.initialPositions.add((Point) p2.clone());
        this.initialPositions.add((Point) p3.clone());
    }

    void translate(int dx, int dy){
        for (Point p : this.positions){
            p.translate(dx, dy);
        }
    }

    void reInit(){
        this.positions.clear();
        for (Point p : this.initialPositions){
            this.positions.add((Point) p.clone());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Positions des balles :\n");
        int index = 1;
        for (Point p : this.positions) {
            sb.append("Balle ").append(index++)
                    .append(" : (x=").append(p.x)
                    .append(", y=").append(p.y).append(")\n");
        }
        return sb.toString();
    }

}
