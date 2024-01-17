package SimpleBoard.sb.repository.mybatis;

import SimpleBoard.sb.domain.Comment;
import SimpleBoard.sb.domain.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
    void replyInsert(Reply reply);

    List<Reply> findAll(@Param("boardId") Long boardId, @Param("commentId") Long CommentId);
}
