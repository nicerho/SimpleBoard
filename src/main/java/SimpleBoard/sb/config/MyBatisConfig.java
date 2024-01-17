package SimpleBoard.sb.config;

import SimpleBoard.sb.repository.BoardRepository;
import SimpleBoard.sb.repository.CommentRepository;
import SimpleBoard.sb.repository.UserRepository;
import SimpleBoard.sb.repository.mybatis.*;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    private final UserMapper userMapper;
    private final BoardMapper boardMapper;
    private final CommentMapper commentMapper;

    public UserRepository userRepository() {
        return new MyBatisUserRepository(userMapper);
    }

    public BoardRepository boardRepository() {
        return new MyBatisBoardRepository(boardMapper);
    }

    public CommentRepository commentRepository() {
        return new MybatisCommentRepository(commentMapper);
    }

}


