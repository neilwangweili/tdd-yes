package yes.tdd.users.domain;

public interface UserRepository {
    User save(User user);
    User findBy(String id);
    User findUserByEmail(String email);
    void removeAll();
}
