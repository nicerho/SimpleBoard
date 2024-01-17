package SimpleBoard.sb.service;

import SimpleBoard.sb.domain.Reply;
import SimpleBoard.sb.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{
    private final ReplyRepository replyRepository;

    @Override
    public void replyInsert(Reply reply) {
        replyRepository.replyInsert(reply);
    }



    @Override
    public List<Reply> findAllReply(Long boardId, Long commentId) {
        return replyRepository.findAllReply(boardId,commentId);
    }
}
