package yes.tdd.users.application;

import yes.tdd.frameworks.application.core.UseCase;
import yes.tdd.users.domain.*;

@UseCase
public class RegisterUserUseCase {
    private final Users users;

    public RegisterUserUseCase(Users users) {
        this.users = users;
    }

    public String execute(UserInput userInput) {
        User user = User.newInstance(userInput.name(), userInput.email());
        users.add(user);
        return user.id();
    }
}
