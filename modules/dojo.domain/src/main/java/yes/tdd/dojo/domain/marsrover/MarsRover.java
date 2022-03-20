package yes.tdd.dojo.domain.marsrover;

public class MarsRover {
    private final Degree degree;
    private final Location location;

    public MarsRover(Mars mars, Towards towards, Double x, Double y) {
        this.degree = new Degree(towards);
        this.location = new Location(x, y, mars);
    }

    public static MarsRover define(Mars mars, Towards towards, Double x, Double y) {
        return new MarsRover(mars, towards, x, y);
    }

    public void executeCommands(String... commands) {
        this.location.towards(degree);
    }

    public String report() {
        return location.report() + ", " + degree.report() + ".";
    }
}
