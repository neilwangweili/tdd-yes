package yes.tdd.dojo.domain.foobarqix;

public class FooBarQix {
    private static final int INT_FOO_TAG = 3;
    private static final String STR_FOO_TAG = "3";
    private final String line;

    public FooBarQix(Integer giving) {
        StringBuilder stringBuilder = new StringBuilder();
        if (giving % INT_FOO_TAG == 0) stringBuilder.append("Foo");
        if (giving.toString().contains(STR_FOO_TAG)) stringBuilder.append("Foo");
        this.line = stringBuilder.toString().isBlank() ? giving.toString() : stringBuilder.toString();
    }

    @Override
    public String toString() {
        return line;
    }
}
