package yes.tdd.dojo.domain.employeereport;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AgeTest {
    @Test
    void should_throw_exception_when_age_is_negative() {
        Throwable throwable = catchThrowable(() -> new Age(0));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("error.age-is-negative");
    }
}
