package yes.tdd.dojo.domain.year;

public final class Year {
    private static final Integer FOR_HUNDRED_YEAR = 400;
    private static final Integer HUNDRED_YEAR = 100;
    private static final Integer LEAP_YEAR = 4;

    private final Integer year;

    public static Year of(Integer year) {
        return new Year(year);
    }

    private Year(Integer year) {
        this.year = year;
    }

    public boolean isLeap() {
        if (year % FOR_HUNDRED_YEAR == 0) return true;
        if (year % HUNDRED_YEAR == 0) return false;
        return year % LEAP_YEAR == 0;
    }
}
