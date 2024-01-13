package SimpleBoard.sb.web;

import SimpleBoard.sb.domain.Board;
import SimpleBoard.sb.domain.User;
import SimpleBoard.sb.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
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

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boardList")
    public String boardList(Model model) {
        List<Board> posts = boardService.findAll();
        System.out.println(posts);
        model.addAttribute("posts",posts);
        return "boardList";
    }

    @GetMapping("/newPost")
    public String newPost(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "newPost";
    }

    @PostMapping("/createPost")
    public String createPost(@ModelAttribute Board board, @RequestParam(required = false,value = "image") MultipartFile image) {
        FTPClient ftp = new FTPClient();
        String extension = StringUtils.getFilenameExtension(image.getOriginalFilename());
        ftp.setControlEncoding("utf-8");
        String filename = image.getOriginalFilename();
        FTPClientConfig ftpConfig = new FTPClientConfig();
        UUID uuid = UUID.randomUUID();
        if(image.getSize()==0){
            boardService.save(board);
            return "redirect:/board/boardList";
        } else{
            try{
                String host = "iup.cdn1.cafe24.com";
                String user = "wjswjdgh123";
                String pass = "qlalfqjsgh1@";
                int port = 21;
                ftp.configure(ftpConfig);
                ftp.connect(host, port);
                if(ftp.login(user,pass)){
                    ftp.setFileType(FTP.BINARY_FILE_TYPE);
                    boolean result = ftp.storeFile("/www/img/" + uuid + "." + extension, image.getInputStream());
                    if(result){
                        board.setImageUrl("http://wjswjdgh123.cdn1.cafe24.com/img/"+uuid+"."+extension);
                        board.setImageName(filename);
                        boardService.save(board);
                        return "redirect:/board/boardList";
                    }else{
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
