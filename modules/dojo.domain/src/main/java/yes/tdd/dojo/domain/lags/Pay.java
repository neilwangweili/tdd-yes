package yes.tdd.dojo.domain.lags;

import yes.tdd.frameworks.domain.core.DomainField;

public class Pay extends DomainField<Integer> {
    public Pay(Integer pay) {
        super(pay, 0, "The price is must be positive!");
    }

    public Integer pay() {
        return super.get();
    }
}
