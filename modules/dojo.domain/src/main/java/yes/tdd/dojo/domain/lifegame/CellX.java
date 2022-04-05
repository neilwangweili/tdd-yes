package yes.tdd.dojo.domain.lifegame;

import java.util.*;

public class CellX {
    private final List<Cell> cells;

    public CellX(int x, String strings) {
        List<Cell> cellsX = new ArrayList<>();
        for (int j = 0; j < x; j++) {
            cellsX.add(Cell.of(strings.charAt(j)));
        }
        this.cells = cellsX;
    }

    public void show(StringBuilder builder) {
        for (Cell cell : cells) {
            builder.append(cell.state());
        }
    }
}
