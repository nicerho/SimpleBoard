package SimpleBoard.sb.service;

import SimpleBoard.sb.domain.Board;
import SimpleBoard.sb.repository.BoardRepository;
import SimpleBoard.sb.repository.BoardUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository boardRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }

    public List<Board> findAll() {
        return boardRepository.findAll();
    }
    public Optional<Board> findById(Long id) {
        Optional<Board> boardOptional = boardRepository.findById(id);
        if (boardOptional.isPresent()) {
            Board board = boardOptional.get();
            return Optional.of(board);
        }
        return Optional.empty();
    }

    @Override
    public List<Board> findPaginatedPosts(int page, int size) {
        int offset = (page - 1) * size;
        return boardRepository.findPaginatedPosts(size,offset);
    }

    @Override
    public void update(Long id, BoardUpdateDto updateDto) {
        boardRepository.update(id,updateDto);
    }

    public int getTotalPosts() {
        return boardRepository.getTotalPosts();
    }

    @Override
    public void delete(Long id) {
        boardRepository.delete(id);
    }
}
