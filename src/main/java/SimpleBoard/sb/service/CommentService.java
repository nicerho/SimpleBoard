package SimpleBoard.sb.service;

import SimpleBoard.sb.domain.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentService {
    void commentInsert(Comment comment);
    void commentDelete(Long id);
    List<Comment> findAll();
}
