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
    default User findUserById(String id) {
        return this.findById(id).asDomain();
    }

    PostgresUser findById(String id);

    @Override
    default User findUserByEmail(String email) {
        return this.findByEmail(email).asDomain();
    }

    PostgresUser findByEmail(String email);

    @Override
    default void removeAll() {
        this.deleteAll();
    }

    void deleteAll();
}
