package LINNET.webcore.controller.web;

import LINNET.webcore.service.repositoty.AccountRepository;
import LINNET.webcore.service.repositoty.RepoRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.logging.Logger;

@Controller
public class WebController {

    Logger logger = Logger.getLogger(WebController.class.getName());

    private final AccountRepository accountRepository;
    private final RepoRepository repoRepository;
    private final HttpSession httpSession;

    public WebController(AccountRepository accountRepository, HttpSession httpSession,RepoRepository repoRepository){
        this.accountRepository = accountRepository;
        this.httpSession = httpSession;
        this.repoRepository = repoRepository;
    }

    @GetMapping("/home")
    public String home(){
        return "home.html";
    }

    @GetMapping("/login")
    public String login(){
        return "login.html";
    }

    @GetMapping("/reg")
    public String reg(){
        return "reg.html";
    }

    @PostMapping("login")
    public String login_post(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model page,
            RedirectAttributes redirectAttributes
    )
    {
        try {
            if (accountRepository.getLogin(username,password) != null){
                httpSession.setAttribute("user",username);
            }
        }catch (EmptyResultDataAccessException e){
            logger.warning("NO SUCH ACCOUNT");
            redirectAttributes.addFlashAttribute("noSuchAccount",true);

        }
        return "redirect:/home";
    }

    @PostMapping("reg")
    public String reg_post(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email
    )
    {
        try {
            accountRepository.getAccountByName(username);
        }catch (EmptyResultDataAccessException e){
            accountRepository.createAccount(username,password,email);
            httpSession.setAttribute("user",username);
        }
        return "redirect:/home";
    }

    @GetMapping("FAQ")
    public String FAQ(Model page){
        return "FAQ.html";
    }

    @GetMapping("newrepo")
    public String newrepo(Model page){
        return "newrepo.html";
    }

    @PostMapping("newrepo")
    public String setrepo(Model page, @RequestParam("reponame") String name){
        repoRepository.createRepo(name, (String) httpSession.getAttribute("user"));
        return "newrepo.html";
    }

    @GetMapping("getrepo")
    public String getrepo(Model page){
        page.addAttribute("repos",repoRepository.getRepo());
        return "getrepo.html";
    }
}
