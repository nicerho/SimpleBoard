package SimpleBoard.sb.repository.mybatis;

import SimpleBoard.sb.domain.Board;
import SimpleBoard.sb.domain.User;
import SimpleBoard.sb.repository.BoardUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.sql.Savepoint;
import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {
    void save(Board board);

    Optional<Board> findById(@Param("id") Long id);

    void update(@Param("id") Long id, BoardUpdateDto updateDto);

    void delete(@Param("id") Long id);

    List<Board> findAll();
}
