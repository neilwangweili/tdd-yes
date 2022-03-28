package yes.tdd.dojo.domain.employeereport;

import yes.tdd.frameworks.domain.core.DomainField;

public class Name extends DomainField<String> {
    public Name(String name) {
        super(name.trim(), "error.name-too-long");
    }

    public String name() {
        return super.get();
    }

    public String report() {
        return name().toUpperCase();
    }
}
