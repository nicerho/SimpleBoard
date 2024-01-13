package SimpleBoard.sb.repository.mybatis;

import SimpleBoard.sb.domain.Board;
import SimpleBoard.sb.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Savepoint;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    void save(Board board);

    Optional<Board> findById(@Param("boardId") Long boardId);
}
