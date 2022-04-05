package yes.tdd.dojo.domain.lifegame;

public class CellGame {
    private Cells cells;

    public CellGame(int x, int y, String input) {
        this.cells = new Cells(input, x, y);
    }

    public static CellGameBuilder build(int x, int y) {
        return new CellGameBuilder(x, y);
    }

    public void nextFrame() {
        this.cells = cells.nextFrame();
    }

    public String show() {
        return cells.show();
    }

    public static class CellGameBuilder {
        private final int x;
        private final int y;

        public CellGameBuilder(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public CellGame newGame(String input) {
            return new CellGame(x, y, input);
        }
    }
}
