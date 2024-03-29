package SimpleBoard.sb.repository.mybatis;

import SimpleBoard.sb.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMapper {
    void save(User user);
    Optional<User> findByUserName(@Param("userName")String userName, @Param("userPw")String userPw);
}
