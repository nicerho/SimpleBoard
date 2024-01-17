package SimpleBoard.sb.service;

import SimpleBoard.sb.domain.Reply;

import java.util.List;

public interface ReplyService {
    void replyInsert(Reply reply);

    List<Reply> findAllReply(Long boardId, Long commentId);

}
