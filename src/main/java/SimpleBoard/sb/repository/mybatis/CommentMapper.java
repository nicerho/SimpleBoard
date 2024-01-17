package SimpleBoard.sb.repository.mybatis;

import SimpleBoard.sb.domain.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommentMapper {
    void commentInsert(Comment comment);
    void commentDelete(@Param("id") Long id);
    List<Comment> findAll();
}
