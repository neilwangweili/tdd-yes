package yes.tdd.users.domain;

import java.util.List;

public interface Users {
    User add(User user);
    User fetchById(String id);
    User fetchByEmail(String email);
    List<User> fetchAll();
    void removeAll();
}
