package yes.tdd.dojo.domain.lags;

import yes.tdd.frameworks.domain.core.DomainField;

public class Duration extends DomainField<Integer> {
    public Duration(Integer duration) {
        super(duration, 0, "Duration must be positive!");
    }

    public Integer duration() {
        return super.get();
    }
}
