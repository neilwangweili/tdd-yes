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
        try {
            Commands.buildFrom(commands).forEach(o -> o.accept(this));
        } catch (MarsRoverOutOfAreaException ignored) {
        }
    }

    public String report() {
        return location.report() + ", " + degree.report() + ".";
    }

    protected void towards() {
        this.location.towards(degree);
    }

    protected void back() {
        this.location.back(degree);
    }

    protected void turnLeft() {
        this.degree.turnLeft();
    }

    protected void turnRight() {
        this.degree.turnRight();
    }

    protected void errorCommand(String command) {
        throw new InsufficientCommandException(command);
    }
}
