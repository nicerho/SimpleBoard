package SimpleBoard.sb.repository.mybatis;

import SimpleBoard.sb.domain.Board;
import SimpleBoard.sb.repository.BoardRepository;
import SimpleBoard.sb.repository.BoardUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MyBatisBoardRepository implements BoardRepository {
    private final BoardMapper boardMapper;

    @Override
    public void save(Board board) {
        boardMapper.save(board);
    }

    @Override
    public Optional<Board> findById(Long id) {
        return boardMapper.findById(id);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Long id, BoardUpdateDto updateDto) {
        boardMapper.update(id,updateDto);
    }

    @Override
    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    public List<Board> findPaginatedPosts(int page, int size) {
        return boardMapper.findPaginatedPosts(page, size);
    }
    @Override
    public int getTotalPosts() {
        return boardMapper.getTotalPosts();
    }
    ;
}
