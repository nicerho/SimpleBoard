package SimpleBoard.sb.web;

import SimpleBoard.sb.domain.User;
import SimpleBoard.sb.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String login() {
        return "boardList";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute User user) {
        userService.save(user);
        return "login";
    }
}
