package yes.tdd.users.application;

import yes.tdd.frameworks.application.core.UseCase;
import yes.tdd.users.domain.*;

@UseCase
public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String execute(UserInput userInput) {
        User user = userInput.asDomain();
        user.save(userRepository);
        return user.id();
    }
}
