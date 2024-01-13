package SimpleBoard.sb.service;

import SimpleBoard.sb.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardService {
    void save(Board board);
    List<Board> findAll();
    Optional<Board> findById(Long id);
    List<Board> findPaginatedPosts(int page, int size);
    int getTotalPosts();
}
