package yes.tdd.dojo.domain.marsrover;

public class MarsRover {
    private final Mars area;
    private final Degree degree;
    private final Location location;

    public MarsRover(Mars mars, Towards towards, Double x, Double y) {
        this.area = mars;
        this.degree = new Degree(towards);
        this.location = new Location(x, y);
    }

    public static MarsRover define(Mars mars, Towards towards, Double x, Double y) {
        return new MarsRover(mars, towards, x, y);
    }

    public void executeCommands(String... commands) {

    }

    public String report() {
        return location.report() + ", " + degree.report() + ".";
    }
}
