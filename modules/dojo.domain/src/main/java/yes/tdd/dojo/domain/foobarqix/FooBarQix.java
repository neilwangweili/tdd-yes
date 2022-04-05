package yes.tdd.dojo.domain.foobarqix;

public class FooBarQix {
    private static final int INT_FOO_TAG = 3;
    private static final String STR_FOO_TAG = "3";
    private static final int INT_BAR_TAG = 5;
    private static final String STR_BAR_TAG = "5";
    private final String line;

    public FooBarQix(Integer giving) {
        StringBuilder stringBuilder = new StringBuilder();
        if (giving % INT_FOO_TAG == 0) stringBuilder.append("Foo");
        if (giving.toString().contains(STR_FOO_TAG)) stringBuilder.append("Foo");
        if (giving % INT_BAR_TAG == 0) stringBuilder.append("Bar");
        if (giving.toString().contains(STR_BAR_TAG)) stringBuilder.append("Bar");
        this.line = stringBuilder.toString().isBlank() ? giving.toString() : stringBuilder.toString();
    }

    @Override
    public String toString() {
        return line;
    }
}
