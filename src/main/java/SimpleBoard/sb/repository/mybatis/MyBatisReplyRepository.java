package SimpleBoard.sb.repository.mybatis;

import SimpleBoard.sb.domain.Reply;
import SimpleBoard.sb.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class MyBatisReplyRepository implements ReplyRepository {
    private final ReplyMapper replyMapper;

    @Override
    public void replyInsert(Reply reply) {

    }

    @Override
    public List<Reply> findAllReply(Long boardId, Long commentId) {
        return replyMapper.findAll(boardId,commentId);
    }


}
