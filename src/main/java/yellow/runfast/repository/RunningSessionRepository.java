package yellow.runfast.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import yellow.runfast.model.RunningSession;
import yellow.runfast.model.User;

/**
 * CRUD repository for {@link RunningSession} entities.
 *
 * @author Alexander Gorovtsov
 */
public interface RunningSessionRepository extends CrudRepository<RunningSession, Long> {

    List<RunningSession> findByUser(User user);

    List<RunningSession> findAll();

}
