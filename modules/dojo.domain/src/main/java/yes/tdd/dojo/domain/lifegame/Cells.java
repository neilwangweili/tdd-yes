package yes.tdd.dojo.domain.lifegame;

import java.util.*;
import java.util.stream.*;

public class Cells {
    private final List<CellX> cells;

    public Cells(String input, int x, int y) {
        String[] strings = input.split("\n");
        this.cells = IntStream.range(0, y).mapToObj(i -> new CellX(x, strings[i])).collect(Collectors.toList());
    }

    public Cells(List<CellX> cells) {
        this.cells = cells;
    }

    public String show() {
        return cells.stream().map(CellX::show).collect(Collectors.joining("\n"));
    }

    public Cells nextFrame() {
        return new Cells(this.cells.stream().map(this::nextFrame).collect(Collectors.toList()));
    }

    private CellX nextFrame(CellX cellX) {
        if (isAtSide(cellX)) return cellX;
        return cellX.nextFrame(cells);
    }

    private boolean isAtSide(CellX cellX) {
        return cells.indexOf(cellX) == 0 || cells.indexOf(cellX) == cells.size() - 1;
    }
}
