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
        User finded = userRepository.findBy(john.id());
        assertEquals(finded.id(), john.id());
        assertEquals(finded.name(), john.name());
        assertEquals(finded.email(), john.email());
    }
}
