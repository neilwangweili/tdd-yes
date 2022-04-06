package yes.tdd.users.application;

import yes.tdd.frameworks.application.core.UseCase;
import yes.tdd.users.domain.*;

@UseCase
public class RegisterUserUseCase {
    private final UserRepository userRepository;

    public RegisterUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String execute(UserInput userInput) {
        User user = User.newInstance(userInput.name(), userInput.email());
        user.save(userRepository);
        return user.id();
    }
}
