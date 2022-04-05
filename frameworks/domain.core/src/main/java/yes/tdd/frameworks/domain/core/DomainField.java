package yes.tdd.frameworks.domain.core;

import com.google.common.collect.ImmutableMap;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;

public class DomainField<T> {
    private T field;
    private final int maxSize;
    private final String errorMsg;

    public DomainField(T field, String errorMsg) {
        this(field, DEFAULT_MAX_SIZE, errorMsg);
    }

    public DomainField(T field, int maxSize, String errorMsg) {
        this.field = field;
        this.maxSize = maxSize;
        this.errorMsg = errorMsg;
        verify();
    }

    public T get() {
        return field;
    }

    protected void set(T field) {
        this.field = field;
        verify();
    }

    protected int maxSize() {
        return maxSize;
    }

    private void verify() {
        basicVerify();
        rewritableVerify();
    }

    private void basicVerify() {
        if (this.field != null && predicate().test(this)) return;
        throw new IllegalArgumentException(errorMsg);
    }

    private static final int DEFAULT_MAX_SIZE = 200;

    private final Map<Class<?>, Predicate<DomainField<?>>> consumerMap = ImmutableMap.of(
        String.class, string(),
        Collection.class, collection(),
        Integer.class, integer(),
        Object.class, object()
    );

    protected Predicate<DomainField<?>> integer() {
        return o -> (Integer) o.get() > maxSize;
    }

    protected Predicate<DomainField<?>> collection() {
        return o -> ((Collection<?>) o.get()).size() <= maxSize;
    }

    protected Predicate<DomainField<?>> string() {
        return o -> ((String) o.get()).length() <= maxSize;
    }

    protected Predicate<DomainField<?>> object() {
        return o -> true;
    }

    /**
     * Implement verification methods as required.
     */
    protected void rewritableVerify() {
    }

    @SuppressWarnings("all")
    private Predicate<DomainField<?>> predicate() {
        return consumerMap.entrySet().stream().filter(o -> o.getKey().isAssignableFrom(field.getClass())).findFirst().get().getValue();
    }
}
