package yes.tdd.dojo.domain.lifegame;

import java.util.*;

public class Cells {
    private final List<CellX> cells;

    public Cells(String input, int x, int y) {
        String[] strings = input.split("\n");
        List<CellX> cells = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            cells.add(new CellX(x, strings[i]));
        }
        this.cells = cells;
    }

    public Cells(List<CellX> cells) {
        this.cells = cells;
    }

    public String show() {
        StringBuilder builder = new StringBuilder();
        for (CellX cellX : cells) {
            cellX.show(builder);
            if (cells.indexOf(cellX) != cells.size() - 1) builder.append("\n");
        }
        return builder.toString();
    }

    public Cells nextFrame() {
        List<CellX> newCells = new ArrayList<>();
        for (CellX cellX : cells) {
            if (cells.indexOf(cellX) == 0 || cells.indexOf(cellX) == cells.size() - 1) {
                newCells.add(cellX);
                continue;
            }
            newCells.add(cellX.nextFrame(cells));
        }
        return new Cells(newCells);
    }
}
