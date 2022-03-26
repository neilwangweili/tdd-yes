package yes.tdd.dojo.domain.year;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static yes.tdd.dojo.domain.year.Year.of;

public class YearTest {
    @ParameterizedTest
    @CsvSource({
        "2017,  'false'",
        "2000,  'true'",
        "2100,  'false'",
        "2012,  'true'"
    })
    void should_be_able_to_find_one_year_is_leap_year(Integer year, boolean isLeap) {
        assertEquals(of(year).isLeap(), isLeap);
    }

    @Test
    void should_throw_exception_when_number_is_negative() {
        Throwable throwable = catchThrowable(() -> of(-2));
        assertThat(throwable).isInstanceOf(IllegalYearException.class).hasMessage("Year must be positive.");
    }
}
