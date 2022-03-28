package yes.tdd.dojo.domain.employeereport;

import yes.tdd.frameworks.domain.core.DomainField;

import java.util.function.Predicate;

public class Age extends DomainField<Integer> {
    public static final int ADULT_AGE = 18;

    public Age(int age) {
        super(age, 0, "error.age-is-negative");
    }

    public Integer age() {
        return super.get();
    }

    public boolean isAdult() {
        return age() >= ADULT_AGE;
    }

    @Override
    protected Predicate<DomainField<?>> integer() {
        return o -> (Integer) o.get() > o.maxSize();
    }

    public String report() {
        return age().toString();
    }
}
