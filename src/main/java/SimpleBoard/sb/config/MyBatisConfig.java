package SimpleBoard.sb.config;

import SimpleBoard.sb.repository.BoardRepository;
import SimpleBoard.sb.repository.UserRepository;
import SimpleBoard.sb.repository.mybatis.BoardMapper;
import SimpleBoard.sb.repository.mybatis.MyBatisBoardRepository;
import SimpleBoard.sb.repository.mybatis.MyBatisUserRepository;
import SimpleBoard.sb.repository.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    private final UserMapper userMapper;
    private final BoardMapper boardMapper;
    public UserRepository userRepository(){
        return new MyBatisUserRepository(userMapper);
    }
    public BoardRepository boardRepository(){
        return new MyBatisBoardRepository(boardMapper);
    }

}
