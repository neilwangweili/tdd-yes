package yes.tdd.dojo.domain.lags;

import org.apache.commons.lang3.StringUtils;
import yes.tdd.frameworks.domain.core.DomainField;

import java.util.function.Predicate;

public class Plane extends DomainField<String> {
    public Plane(String plane) {
        super(plane.trim(), "The plane name is invalid!");
    }

    @Override
    protected Predicate<DomainField<?>> string() {
        return o -> ((String) o.get()).length() <= super.maxSize() && StringUtils.isNotEmpty((String) o.get());
    }

    public String plane() {
        return super.get();
    }
}
