package yes.tdd.dojo.domain.foobarqix;

public class FooBarQix {
    private static final int INT_FOO_TAG = 3;
    private static final int INT_BAR_TAG = 5;
    private static final int INT_QIX_TAG = 7;
    private final String line;

    public FooBarQix(Integer giving) {
        if (!giving.toString().contains("0")) {
            StringBuilder stringBuilder = build(giving);
            this.line = stringBuilder.toString().isBlank() ? giving.toString() : stringBuilder.toString();
        } else {
            String result = giving.toString();
            while (result.contains("0")) {
                StringBuilder stringBuilder = build(giving).append("*");
                result = stringBuilder + result.substring(0, result.indexOf("0") + 1);
            }
            this.line = result;
        }
    }

    private StringBuilder build(Integer giving) {
        StringBuilder builder = new StringBuilder();
        build(builder, giving, INT_FOO_TAG, "Foo");
        build(builder, giving, INT_BAR_TAG, "Bar");
        build(builder, giving, INT_QIX_TAG, "Qix");
        return builder;
    }

    private void build(StringBuilder stringBuilder, Integer giving, Integer tag, String append) {
        if (canDivide(giving, tag)) stringBuilder.append(append);
        if (contains(giving, tag.toString())) stringBuilder.append(append);
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
