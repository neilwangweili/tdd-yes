package yes.tdd.dojo.domain.marsrover;

public class Mars {
    private final double x;
    private final double y;

    public Mars(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static Mars build(double x, double y) {
        return new Mars(x, y);
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public void verify(Double targetX, Double targetY) {
        if (targetX <= x && targetY <= y && targetX >= 0 && targetY >= 0) return;
        throw new MarsRoverOutOfAreaException();
    }
}
