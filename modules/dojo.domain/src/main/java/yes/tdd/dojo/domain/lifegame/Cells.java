package yes.tdd.dojo.domain.lifegame;

import java.util.*;

public class Cells {
    private final List<List<Cell>> cells;

    public Cells(String input, int x, int y) {
        String[] strings = input.split("\n");
        List<List<Cell>> cells = new ArrayList<>();
        for (int i = 0; i < y; i++) {
            List<Cell> cellsX = new ArrayList<>();
            for (int j = 0; j < x; j++) {
                cellsX.add(Cell.of(strings[i].charAt(j)));
            }
            cells.add(cellsX);
        }
        this.cells = cells;
    }

    public String show() {
        StringBuilder builder = new StringBuilder();
        for (List<Cell> cellX : cells) {
            for (Cell cell : cellX) {
                builder.append(cell.state());
            }
            if (cells.indexOf(cellX) != cells.size() - 1) builder.append("\n");
        }
        return builder.toString();
    }
}
