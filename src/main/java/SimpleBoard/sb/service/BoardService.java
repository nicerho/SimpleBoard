package SimpleBoard.sb.service;

import SimpleBoard.sb.domain.Board;
import SimpleBoard.sb.domain.User;
import SimpleBoard.sb.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void save(Board board) {


        boardRepository.save(board);
    }


}
