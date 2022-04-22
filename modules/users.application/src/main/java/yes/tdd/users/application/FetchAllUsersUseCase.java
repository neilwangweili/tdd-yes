package yes.tdd.users.application;

import yes.tdd.frameworks.application.core.UseCase;
import yes.tdd.users.application.vo.UserOutputs;
import yes.tdd.users.domain.Users;

@UseCase
public class FetchAllUsersUseCase {
    private final Users users;

    public FetchAllUsersUseCase(Users users) {
        this.users = users;
    }

    public UserOutputs execute() {
        return UserOutputs.from(users.fetchAll());
    }
}
