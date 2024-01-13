package SimpleBoard.sb.repository.mybatis;

import SimpleBoard.sb.domain.User;
import SimpleBoard.sb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisUserRepository implements UserRepository {
    private final UserMapper userMapper;

    @Override
    public User save(User user) {
        userMapper.save(user);
        return user;
    }
    @Override
    public Optional<User> findByUserName(String userName,String userPw) {
        return userMapper.findByUserName(userName,userPw);
    }


}
