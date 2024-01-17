package SimpleBoard.sb.domain;

import lombok.Data;

@Data
public class Reply {
    private Long id;
    private String userName;
    private String content;
    private String createdAt;
    private Long commentId;
    private Long boardId;
}
