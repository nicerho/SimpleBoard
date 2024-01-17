package SimpleBoard.sb.domain;

import lombok.Data;

@Data
public class Comment {
    private Long id;
    private String userName;
    private String commentText;
    private String createdAt;
    private Long boardId;
    private Long userId;
}
