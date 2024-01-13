package SimpleBoard.sb.web;

import SimpleBoard.sb.domain.Board;
import SimpleBoard.sb.domain.User;
import SimpleBoard.sb.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boardList")
    public String test() {
        return "boardList";
    }

    @GetMapping("/newPost")
    public String newPost(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "newPost";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Board board) {
        System.out.println(board);
        boardService.save(board);
        return "redirect:/board/boardList";
    }
}
