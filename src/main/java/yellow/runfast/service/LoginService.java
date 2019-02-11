package yellow.runfast.service;

import yellow.runfast.model.User;

/**
 * Login/register service
 *
 * @author Alexande Gorovtsov
 */
public interface LoginService {

    boolean logIn(String login, String password);

    User register(User user);
}
