package yellow.runfast.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Home controller of app
 *
 * @author Alexander Gorovtsov
 */
@RestController
public class HomeController {

    @GetMapping("/")
    public String hello() {
        return "Hello yellow";
    }

}
