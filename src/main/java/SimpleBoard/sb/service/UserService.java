package SimpleBoard.sb.service;

import SimpleBoard.sb.domain.User;
import SimpleBoard.sb.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User save(User user){
        return userRepository.save(user);
    }
}
