package yellow.runfast.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yellow.runfast.model.User;
import yellow.runfast.repository.UserRepository;
import yellow.runfast.service.LoginService;

/**
 * Implementation of {@link LoginService}
 *
 * @author Alexander Gorovtsov
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean logIn(String login, String password) {
        User user = Optional.of(userRepository.findByLogin(login))
            .orElseThrow(() -> new IllegalArgumentException("No such user"));

        return user.getPassword().equals(password);
    }

    @Override
    public User register(User user) {
        return userRepository.save(user);
    }

}
