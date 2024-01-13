package SimpleBoard.sb.service;

import SimpleBoard.sb.domain.User;
import SimpleBoard.sb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findByUserName(String userName, String userPw) {
        Optional<User> userOptional = userRepository.findByUserName(userName, userPw);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
