package LINNET.webcore.controller.web;

import LINNET.webcore.repositoty.AuthRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    HttpSession session;
    AuthRepository authRepository;

    public  MainController(HttpSession session, AuthRepository authRepository){
        this.session = session;
        this.authRepository = authRepository;
    }

    @GetMapping("/home")
    public String home()    {return "home.html";}

    @GetMapping("/login")
    public String login()   {return "login.html";}
        @PostMapping("login")
        public String login(
                @RequestParam("username") String username,
                @RequestParam("password") String password
        )
        {
        if (authRepository.checkAdmin(username, password)){
            session.setAttribute("user","username");
            return "redirect:/home";
        }
        return "redirect:/home";}

    @GetMapping("/reg")
    public String reg()     {return "reg.html";}

    @GetMapping("faq")
    public String faq()     {return "faq.html";}
}
