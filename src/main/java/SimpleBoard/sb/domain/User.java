package SimpleBoard.sb.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    private String userPw;
    private String regDate;
}
