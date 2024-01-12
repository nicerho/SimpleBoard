package SimpleBoard.sb.repository;

import SimpleBoard.sb.domain.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findByUserName(String userName);
}
