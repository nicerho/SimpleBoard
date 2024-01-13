package SimpleBoard.sb.web;

import SimpleBoard.sb.domain.User;
import SimpleBoard.sb.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final UserService userService;


    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String showSignupPage() {
        return "signup";
    }

    @PostMapping("/login")
    public String login(@RequestParam(name = "userName") String userName, @RequestParam(name = "userPw") String userPw, HttpServletRequest req) {
        Optional<User> userOptional = userService.findByUserName(userName, userPw);
        if (userOptional.isEmpty()) {
            return "redirect:/login";
        }
        User user = userOptional.get();
        HttpSession session = req.getSession();
        session.setAttribute("user", user);
        session.setMaxInactiveInterval(1800);
        return "redirect:/board/boardList";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user) {
        userService.save(user);
        return "login";
    }
}
