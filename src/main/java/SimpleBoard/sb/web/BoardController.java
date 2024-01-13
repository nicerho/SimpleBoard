package SimpleBoard.sb.web;

import SimpleBoard.sb.domain.Board;
import SimpleBoard.sb.domain.User;
import SimpleBoard.sb.service.BoardServiceImpl;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardServiceImpl boardService;

    @GetMapping("/boardList")
    public String boardList(@RequestParam(name = "page", defaultValue = "1") int page,
                            @RequestParam(name = "size", defaultValue = "5") int size
            , Model model) {
        List<Board> posts = boardService.findPaginatedPosts(page, size);
        int totalPosts = boardService.getTotalPosts();
        int totalPages = (int) Math.ceil((double) totalPosts / size);
        model.addAttribute("posts", posts);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("pageSize", size);
        return "boardList";
    }

    @GetMapping("/newPost")
    public String newPost(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "newPost";
    }

    @GetMapping("/{id}")
    public String board(@PathVariable(name = "id") long id, Model model) {
        Optional<Board> boardOptional = boardService.findById(id);
        if (boardOptional.isEmpty()) {
            return "redirect:/board/boardList";
        }
        Board post = boardOptional.get();
        System.out.println(post);
        return null;
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Board board, @RequestParam(required = false, value = "image") MultipartFile image) {
        FTPClient ftp = new FTPClient();
        String extension = StringUtils.getFilenameExtension(image.getOriginalFilename());
        ftp.setControlEncoding("utf-8");
        String filename = image.getOriginalFilename();
        FTPClientConfig ftpConfig = new FTPClientConfig();
        UUID uuid = UUID.randomUUID();
        if (image.getSize() == 0) {
            boardService.save(board);
            return "redirect:/board/boardList";
        } else {
            try {
                String host = "iup.cdn1.cafe24.com";
                String user = "wjswjdgh123";
                String pass = "qlalfqjsgh1@";
                int port = 21;
                ftp.configure(ftpConfig);
                ftp.connect(host, port);
                if (ftp.login(user, pass)) {
                    ftp.setFileType(FTP.BINARY_FILE_TYPE);
                    boolean result = ftp.storeFile("/www/img/" + uuid + "." + extension, image.getInputStream());
                    if (result) {
                        board.setImageUrl("http://wjswjdgh123.cdn1.cafe24.com/img/" + uuid + "." + extension);
                        board.setImageName(filename);
                        boardService.save(board);
                        return "redirect:/board/boardList";
                    } else {
                        throw new IllegalStateException();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "redirect:/board/boardList";
    }
}
