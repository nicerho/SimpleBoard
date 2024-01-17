package SimpleBoard.sb.service;

import SimpleBoard.sb.domain.Comment;
import SimpleBoard.sb.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
    private final CommentRepository commentRepository;
    @Override
    public void commentInsert(Comment comment) {
        commentRepository.commentInsert(comment);
    }

    @Override
    public void commentDelete(Long id) {
        commentRepository.commentDelete(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }
}
