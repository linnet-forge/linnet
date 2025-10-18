package LINNET.webcore.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoreController {
    @PostMapping("/like")
    public String like(@RequestParam("yakehara") String name){
        return "like";
    }
}
