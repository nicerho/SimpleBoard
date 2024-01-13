package SimpleBoard.sb.domain;

import lombok.Data;

@Data
public class Board {
    private Long id;
    private String userName;
    private String title;
    private String createdAt;
    private Long userId;
    private String content;
    private String imageUrl;

}
