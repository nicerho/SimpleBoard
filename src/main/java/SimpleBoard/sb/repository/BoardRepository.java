package SimpleBoard.sb.repository;

import SimpleBoard.sb.domain.Board;
import java.util.Optional;

public interface BoardRepository {

    void save(Board board);

    Optional<Board> findById(Long id);

    void delete(Long id);

    void update(Long id, BoardUpdateDto updateDto);
}
