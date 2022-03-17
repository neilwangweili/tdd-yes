package yes.tdd.dojo.domain.unit;

public enum UnitHub {
    CM(100.0), DM(10.0), M(1.0);

    private final Double formula;

    UnitHub(Double formula) {
        this.formula = formula;
    }

    public Double formula() {
        return formula;
    }
}
