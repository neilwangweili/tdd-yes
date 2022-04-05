package yes.tdd.dojo.domain.foobarqix;

public class FooBarQix {
    private static final int INT_FOO_TAG = 3;
    private static final int INT_BAR_TAG = 5;
    private static final int INT_QIX_TAG = 7;
    private final String line;

    public FooBarQix(Integer giving) {
        StringBuilder stringBuilder = new StringBuilder();
        build(stringBuilder, giving, INT_FOO_TAG, "Foo");
        build(stringBuilder, giving, INT_BAR_TAG, "Bar");
        build(stringBuilder, giving, INT_QIX_TAG, "Qix");
        this.line = stringBuilder.toString().isBlank() ? giving.toString() : stringBuilder.toString();
    }

    private void build(StringBuilder stringBuilder, Integer giving, Integer intTag, String append) {
        if (canDivide(giving, intTag)) stringBuilder.append(append);
        if (contains(giving, intTag.toString())) stringBuilder.append(append);
    }

    private boolean contains(Integer giving, String strFooTag) {
        return giving.toString().contains(strFooTag);
    }

    private boolean canDivide(Integer giving, int intFooTag) {
        return giving % intFooTag == 0;
    }

    @Override
    public String toString() {
        return line;
    }
}
