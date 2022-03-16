package yes.tdd.users.application;

import yes.tdd.frameworks.application.core.UseCase;
import yes.tdd.users.application.vo.UserOutputs;
import yes.tdd.users.domain.*;

@UseCase
public class SearchAllUsersUseCase {
    private final UserRepository userRepository;

    public SearchAllUsersUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserOutputs execute() {
        return UserOutputs.from(Users.findAll(userRepository));
    }
}
