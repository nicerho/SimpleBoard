package SimpleBoard.sb.repository;

import SimpleBoard.sb.domain.Reply;

import java.util.List;

public interface ReplyRepository {
    void replyInsert(Reply reply);

    List<Reply> findAllReply(Long boardId,Long commentId);
}
