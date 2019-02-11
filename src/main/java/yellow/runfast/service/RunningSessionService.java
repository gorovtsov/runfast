package yellow.runfast.service;

import java.util.List;

import yellow.runfast.model.RunningSession;
import yellow.runfast.model.User;

/**
 * Business logic incapsulation for {@link RunningSession}
 *
 * @author Alexander Gorovtsov
 */
public interface RunningSessionService {

    void save(RunningSession runningSession);

    RunningSession findById(Long id);

    List<RunningSession> findByUser(User user);

    void deleteById(Long id);

}
