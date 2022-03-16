package yes.tdd.usecases;

import org.junit.jupiter.api.Test;
import yes.tdd.IntegrationTest;
import yes.tdd.users.domain.*;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

public class SaveUserTest extends IntegrationTest {
    private @Resource UserRepository userRepository;

    @Test
    void should_be_able_to_save_one_user_and_find_it_by_id() {
        User john = userRepository.save(User.newInstance("John", "john.smith@email.com"));
        assertNotEquals("", john.id());
        User fount = userRepository.findBy(john.id());
        assertEquals(fount.id(), john.id());
        assertEquals(fount.name(), john.name());
        assertEquals(fount.email(), john.email());
    }
}
