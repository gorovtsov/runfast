package yellow.runfast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import yellow.runfast.model.User;
import yellow.runfast.service.LoginService;

/**
 * Login/register controller
 *
 * @author Alexander Gorovtsov
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public boolean login(String login, String password) {
        return loginService.logIn(login, password);
    }

    @PostMapping("/register")
    public User register(User user) {
        return loginService.register(user);
    }
}
