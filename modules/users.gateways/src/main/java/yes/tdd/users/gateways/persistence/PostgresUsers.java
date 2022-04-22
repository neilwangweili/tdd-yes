package yes.tdd.users.gateways.persistence;

import org.springframework.data.repository.Repository;
import yes.tdd.users.domain.*;

import java.util.List;
import java.util.stream.*;

public interface PostgresUsers extends Repository<PostgresUser, String>, Users {
    @Override
    default User add(User user) {
        return this.save(new PostgresUser(user)).asDomain();
    }

    PostgresUser save(PostgresUser user);

    @Override
    default User fetchById(String id) {
        return this.findById(id).asDomain();
    }

    PostgresUser findById(String id);

    @Override
    default User fetchByEmail(String email) {
        return this.findByEmail(email).asDomain();
    }

    PostgresUser findByEmail(String email);

    @Override
    default List<User> fetchAll() {
        return this.findAll().map(PostgresUser::asDomain).collect(Collectors.toList());
    }

    Stream<PostgresUser> findAll();

    @Override
    default void removeAll() {
        this.deleteAll();
    }

    void deleteAll();
}
