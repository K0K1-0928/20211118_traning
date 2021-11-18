package jp.evolveit.kouki_murakami.rest_api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    
    @GetMapping("/test")
    public String index() {
        return "index";
    }
}
