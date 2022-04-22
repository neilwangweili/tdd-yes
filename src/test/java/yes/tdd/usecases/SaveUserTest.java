package yes.tdd.usecases;

import org.junit.jupiter.api.*;
import yes.tdd.IntegrationTest;
import yes.tdd.users.domain.*;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveUserTest extends IntegrationTest {
    private @Resource Users users;
    private User john;

    @BeforeEach
    void setUp() {
        john = User.newInstance("John", "john.smith@email.com");
        users.add(john);
    }

    @Test
    void should_be_able_to_save_one_user_and_loaded_saved_user() {
        User fount = users.fetchById(john.id());
        assertEquals(fount.id(), john.id());
        assertEquals(fount.name(), john.name());
        assertEquals(fount.email(), john.email());
    }

    @Test
    void should_be_able_to_load_saved_user_by_email() {
        User fount = users.fetchByEmail("john.smith@email.com");
        assertEquals(fount.id(), john.id());
        assertEquals(fount.name(), john.name());
        assertEquals(fount.email(), john.email());
    }

    @AfterEach
    void tearDown() {
        users.removeAll();
    }
}
