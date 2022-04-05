package yes.tdd.dojo.domain.lifegame;

import java.util.*;

public class CellX {
    private static final int TWO = 2;
    private static final int THREE = 3;
    private final List<Cell> cells;

    public CellX(int x, String strings) {
        List<Cell> cellsX = new ArrayList<>();
        for (int j = 0; j < x; j++) {
            cellsX.add(Cell.of(strings.charAt(j)));
        }
        this.cells = cellsX;
    }

    public CellX(List<Cell> newCells) {
        this.cells = newCells;
    }

    public void show(StringBuilder builder) {
        for (Cell cell : cells) {
            builder.append(cell.state());
        }
    }

    public CellX nextFrame(List<CellX> cells) {
        List<Cell> newCells = new ArrayList<>();
        for (int i = 0; i < this.cells.size(); i++) {
            if (i == 0 || i == this.cells.size() - 1) {
                newCells.add(this.cells.get(i));
                continue;
            }
            newCells.add(Cell.of(newState(calculateLivingCellsCount(cells, i), i)));
        }
        return new CellX(newCells);
    }

    private char newState(int count, int i) {
        if (getCellState(i) == 1 && (count < TWO || count > THREE)) return '.';
        if (getCellState(i) == 1) return '*';
        if (count >= THREE) return '*';
        return '.';
    }

    private Integer calculateLivingCellsCount(List<CellX> cells, int i) {
        int y = cells.indexOf(this);
        int result = cells.get(y - 1).getCellState(i);
        result += cells.get(y - 1).getCellState(i - 1);
        result += cells.get(y - 1).getCellState(i + 1);
        result += cells.get(y + 1).getCellState(i);
        result += cells.get(y + 1).getCellState(i - 1);
        result += cells.get(y + 1).getCellState(i + 1);
        result += this.getCellState(i - 1);
        result += this.getCellState(i + 1);
        return result;
    }

    private Integer getCellState(int i) {
        return this.cells.get(i).count();
    }
}
