package example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @Value("${info.foo}")
    private String fooProperty;

    @RequestMapping("/")
    public String hello() {
        return "Using [" + fooProperty + "] from config server";
    }
}
