package SimpleBoard.sb.repository.mybatis;

import SimpleBoard.sb.domain.Comment;
import SimpleBoard.sb.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MybatisCommentRepository implements CommentRepository {
    private final CommentMapper commentMapper;
    @Override
    public void commentInsert(Comment comment) {
        commentMapper.commentInsert(comment);


    }

    @Override
    public void commentDelete(Long id) {

    }

    @Override
    public List<Comment> findAll() {
        return commentMapper.findAll();
    }
}