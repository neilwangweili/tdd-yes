package yes.tdd.dojo.domain.employeereport;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AgeTest {
    @Test
    void should_throw_exception_when_age_is_negative() {
        assertThat(catchThrowable(() -> new Age(0))).isInstanceOf(IllegalArgumentException.class).hasMessage("error.age-is-negative");
    }
}
