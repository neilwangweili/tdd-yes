package yes.tdd.dojo.domain.year;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

public class YearTest {
    @ParameterizedTest
    @CsvSource({
        "2017,  'false'",
        "2000,  'true'",
        "2100,  'false'",
        "2012,  'true'"
    })
    void should_be_able_to_find_one_year_is_leap_year(Integer year, boolean isLeap) {
        assertEquals(Year.of(year).isLeap(), isLeap);
    }
}
