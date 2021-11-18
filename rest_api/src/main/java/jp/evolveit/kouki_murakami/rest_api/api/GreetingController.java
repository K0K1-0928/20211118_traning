package jp.evolveit.kouki_murakami.rest_api.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    
    @PostMapping("/api/greeting")
    public GreetingResponse greeting(@RequestBody GreetingRequest request) {
        return new GreetingResponse("Hello" + request.getName() + "!");
    }
}
