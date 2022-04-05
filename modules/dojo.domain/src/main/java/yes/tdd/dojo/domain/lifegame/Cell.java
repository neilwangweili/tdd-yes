package yes.tdd.dojo.domain.lifegame;

public final class Cell {
    private boolean state;

    private Cell(char state) {
        this.state = '*' == state;
    }

    public static Cell of(char state) {
        return new Cell(state);
    }

    public String state() {
        return state ? "*" : ".";
    }
}
