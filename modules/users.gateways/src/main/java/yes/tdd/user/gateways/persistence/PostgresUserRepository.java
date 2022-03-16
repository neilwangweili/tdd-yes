package yes.tdd.user.gateways.persistence;

import org.springframework.data.repository.Repository;
import yes.tdd.users.domain.User;
import yes.tdd.users.domain.UserRepository;

public interface PostgresUserRepository extends Repository<PostgresUser, String>, UserRepository {
    @Override
    default User save(User user) {
        return this.save(new PostgresUser(user)).asDomain();
    }

    PostgresUser save(PostgresUser user);

    @Override
    default User findBy(String id) {
        return this.findById(id).asDomain();
    }

    PostgresUser findById(String id);
}
