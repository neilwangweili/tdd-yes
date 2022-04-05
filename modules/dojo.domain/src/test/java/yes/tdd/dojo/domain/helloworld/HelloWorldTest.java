package yes.tdd.dojo.domain.helloworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldTest {
    @Test
    void should_be_able_to_generate_hello_world_successfully() {
        assertEquals(new HelloWorld().greet(), "Hello world.");
    }
}
