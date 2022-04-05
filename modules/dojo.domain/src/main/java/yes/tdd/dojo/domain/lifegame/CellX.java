package yes.tdd.dojo.domain.lifegame;

import java.util.List;
import java.util.stream.*;

public class CellX {
    private static final int TWO = 2;
    private static final int THREE = 3;
    private final List<Cell> cells;

    public CellX(int x, String strings) {
        this.cells = IntStream.range(0, x).mapToObj(i -> Cell.of(strings.charAt(i))).collect(Collectors.toList());
    }

    public CellX(List<Cell> newCells) {
        this.cells = newCells;
    }

    public String show() {
        return cells.stream().map(Cell::state).collect(Collectors.joining());
    }

    public CellX nextFrame(List<CellX> cells) {
        return new CellX(IntStream.range(0, this.cells.size()).mapToObj(i -> addCells(cells, i)).collect(Collectors.toList()));
    }

    private Cell addCells(List<CellX> cells, int i) {
        if (isAtSide(i)) return this.cells.get(i);
        return Cell.of(newState(calculateLivingCellsCount(cells, i), i));
    }

    private boolean isAtSide(int i) {
        return i == 0 || i == this.cells.size() - 1;
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
