package SimpleBoard.sb.repository;

import SimpleBoard.sb.domain.Comment;

import java.util.List;

public interface CommentRepository {
    void commentInsert(Comment comment);
    void commentDelete(Long id);
    List<Comment> findAll();
}
