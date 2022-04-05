package yes.tdd.dojo.domain.lags;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PlaneTest {
    @Test
    void should_throw_exception_when_create_empty_plane() {
        Throwable throwable = catchThrowable(() -> new Plane(""));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("The plane name is invalid!");
    }

    @Test
    void should_throw_exception_when_create_too_large_name_plane() {
        Throwable throwable = catchThrowable(() -> new Plane("namenamenamenamenamenamenamenamenamenamenamename" +
            "namenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamename" +
            "namenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamenamename"));
        assertThat(throwable).isInstanceOf(IllegalArgumentException.class).hasMessage("The plane name is invalid!");
    }
}
