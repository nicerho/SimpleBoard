package SimpleBoard.sb.config;

import SimpleBoard.sb.repository.mybatis.BoardMapper;
import SimpleBoard.sb.repository.mybatis.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class MyBatisConfig {
    private final UserMapper userMapper;
    private final BoardMapper boardMapper;
}
