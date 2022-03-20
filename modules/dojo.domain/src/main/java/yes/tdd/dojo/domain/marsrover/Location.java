package yes.tdd.dojo.domain.marsrover;

public class Location {
    private final Mars area;
    private Double x;
    private Double y;

    private static final Double TRAVEL_DISTANCE = 1.0;

    public Location(Double x, Double y, Mars mars) {
        this.area = mars;
        this.x = x;
        this.y = y;
        area.verify(x, y);
    }

    public String report() {
        return "I'm at (" + x + ", " + y + ")";
    }

    public void towards(Degree degree) {
        move(this.x + horizontalAxisTravelDistance(degree), this.y + verticalAxisTravelDistance(degree));
    }

    public void back(Degree degree) {
        move(this.x - horizontalAxisTravelDistance(degree), this.y - verticalAxisTravelDistance(degree));
    }

    private double verticalAxisTravelDistance(Degree degree) {
        return TRAVEL_DISTANCE * degree.orthogonalDecompose().getRight();
    }

    private double horizontalAxisTravelDistance(Degree degree) {
        return TRAVEL_DISTANCE * degree.orthogonalDecompose().getLeft();
    }

    private void move(Double targetX, Double targetY) {
        area.verify(targetX, targetY);
        this.x = targetX;
        this.y = targetY;
    }
}
