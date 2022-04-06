package yes.tdd.dojo.domain.year;

import yes.tdd.frameworks.domain.core.DomainField;

public final class Year extends DomainField<Integer> {
    private static final Integer FOR_HUNDRED_YEAR = 400;
    private static final Integer HUNDRED_YEAR = 100;
    private static final Integer LEAP_YEAR = 4;

    public static Year of(Integer year) {
        return new Year(year);
    }

    private Year(Integer year) {
        super(year, 0, "Year must be positive.");
    }

    public boolean isLeap() {
        if (year() % FOR_HUNDRED_YEAR == 0) return true;
        if (year() % HUNDRED_YEAR == 0) return false;
        return year() % LEAP_YEAR == 0;
    }

    private int year() {
        return super.get();
    }
}
