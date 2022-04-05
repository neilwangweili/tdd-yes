package yes.tdd.dojo.domain.foobarqix;

import org.apache.commons.lang3.StringUtils;

public class FooBarQix {
    private static final int INT_FOO_TAG = 3;
    private static final int INT_BAR_TAG = 5;
    private static final int INT_QIX_TAG = 7;
    private static final String STAR = "0";
    private final String line;

    public FooBarQix(Integer giving) {
        String givingString = giving.toString();
        StringBuilder result = new StringBuilder();
        while (StringUtils.isNotEmpty(givingString)) {
            appendNums(givingString, result);
            givingString = produceGivingString(givingString, result);
        }
        this.line = result.toString();
    }

    private void appendNums(String givingString, StringBuilder result) {
        StringBuilder builder = build(Integer.valueOf(givingString));
        if (isEmpty(builder) && !givingString.contains(STAR)) builder = new StringBuilder(givingString);
        if (isEmpty(builder)) builder = new StringBuilder(givingString.substring(0, givingString.indexOf(STAR)));
        result.append(builder);
    }

    private String produceGivingString(String givingString, StringBuilder result) {
        if (!givingString.contains(STAR)) givingString = "";
        else {
            givingString = givingString.substring(givingString.indexOf(STAR) + 1);
            result.append("*");
        }
        return givingString;
    }

    private boolean isEmpty(StringBuilder builder) {
        return builder.toString().isEmpty();
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
