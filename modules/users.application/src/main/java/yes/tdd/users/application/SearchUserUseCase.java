package yes.tdd.users.application;

import yes.tdd.frameworks.application.core.UseCase;
import yes.tdd.users.application.vo.UserOutput;
import yes.tdd.users.domain.*;

@UseCase
public class SearchUserUseCase {
    private final UserRepository userRepository;

    public SearchUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserOutput execute(String id) {
        return UserOutput.from(User.findById(id, userRepository));
    }
}
