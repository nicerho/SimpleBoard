package SimpleBoard.sb.repository.mybatis;

import SimpleBoard.sb.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void save(User user);
    Optional<User> findByUserName(String userName);
}
