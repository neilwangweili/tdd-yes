package yes.tdd.users.application;

import yes.tdd.frameworks.application.core.UseCase;
import yes.tdd.users.application.vo.UserOutput;
import yes.tdd.users.domain.*;

@UseCase
public class FetchUserUseCase {
    private final Users users;

    public FetchUserUseCase(Users users) {
        this.users = users;
    }


    public UserOutput execute(String id) {
        return UserOutput.from(users.fetchById(id));
    }
}
