package yellow.runfast.repository;

import org.springframework.data.repository.CrudRepository;

import yellow.runfast.model.User;

/**
 * Repository for {@link User} entities
 *
 * @author Alexander Gorovtsov
 */
public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);

}
