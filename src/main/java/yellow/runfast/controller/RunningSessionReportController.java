package yellow.runfast.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import yellow.runfast.model.RunningSession;
import yellow.runfast.model.RunningSessionWeeklyReport;
import yellow.runfast.model.User;
import yellow.runfast.repository.RunningSessionRepository;
import yellow.runfast.repository.UserRepository;
import yellow.runfast.service.RunningReportService;

@RestController
public class RunningSessionReportController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RunningSessionRepository sessionRepository;

    @Autowired
    private RunningReportService reportService;

    @GetMapping("/user/{userId}/sessions")
    public List<RunningSession> getAllRunningSessions(@PathVariable String userId) {
        return sessionRepository.findByUser(findUser(userId));
    }

    @GetMapping("/user/{userId}/reports")
    public List<RunningSessionWeeklyReport> getUserReports(@PathVariable String userId) {

        return reportService.getAllReportsByUser(findUser(userId));
    }

    private User findUser(String userId) {
        return userRepository.findById(Long.parseLong(userId))
            .orElseThrow(() -> new IllegalArgumentException("No such user"));
    }
}
