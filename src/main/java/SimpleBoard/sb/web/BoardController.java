package SimpleBoard.sb.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {
    @GetMapping
    public String test(){
        return "boardList";
    }
}
