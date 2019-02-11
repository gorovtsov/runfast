package yellow.runfast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import yellow.runfast.model.RunningSession;
import yellow.runfast.repository.RunningSessionRepository;

/**
 * CRUD controller for {@link RunningSession}
 *
 * @author Alexander Gorovtsov
 */
@RestController
public class RunningSessionController {

    @Autowired
    private RunningSessionRepository sessionRepository;

    @GetMapping("/sessions")
    public List<RunningSession> getAllRunningSessions() {
        return sessionRepository.findAll();
    }

    @PutMapping("/sessions/save")
    public void saveSession(@PathVariable String userId, RunningSession session) {
        sessionRepository.save(session);
    }

    @PutMapping("/sessions/update")
    public void updateSession(RunningSession session) {
        sessionRepository.save(session);
    }

    @DeleteMapping("/sessions/delete")
    public void deleteSession(RunningSession session) {
        sessionRepository.delete(session);
    }

}
