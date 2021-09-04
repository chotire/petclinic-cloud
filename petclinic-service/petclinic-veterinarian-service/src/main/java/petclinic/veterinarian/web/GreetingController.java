package petclinic.veterinarian.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GreetingController {
    @Value("${greeting.message}")
    private String message;

    @GetMapping("/greeting")
    String greeting() {
        return message;
    }
}
