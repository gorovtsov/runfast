package yellow.runfast.service.impl;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import yellow.runfast.model.RunningSession;
import yellow.runfast.model.RunningSessionWeeklyReport;
import yellow.runfast.model.User;
import yellow.runfast.repository.RunningSessionRepository;
import yellow.runfast.service.RunningReportService;

import static yellow.runfast.util.DateUtils.getFirstDayOfWeek;
import static yellow.runfast.util.DateUtils.getLastDayOfWeek;
import static yellow.runfast.util.DateUtils.isSameWeek;

/**
 * Implementation of {@link RunningReportService}
 *
 * @author Alexander Gorovtosov
 */
@AllArgsConstructor

@Service
public class RunningReportServiceImpl implements RunningReportService {

    @Resource
    private RunningSessionRepository runningSessionRepository;

    @Override
    public List<RunningSessionWeeklyReport> getAllReportsByUser(User user) {
        List<RunningSession> sessions = runningSessionRepository.findByUser(user);

        Map<Integer, List<RunningSession>> weekPortions = divideByWeeks(sessions);

        return weekPortions.entrySet()
            .stream()
            .map(entry -> generateReport(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());
    }

    private Map<Integer, List<RunningSession>> divideByWeeks(List<RunningSession> sessions) {
        Map<Integer, List<RunningSession>> weekPortions = new HashMap<>();

        for (RunningSession session : sessions) {
            if (weekPortions.isEmpty()) {
                weekPortions.put(1, createNewPortion(session));
            } else {
                putInCorrectWeek(weekPortions, session);
            }
        }

        return weekPortions;
    }

    private void putInCorrectWeek(Map<Integer, List<RunningSession>> weekPortions, RunningSession session) {
        List<RunningSession> sessions = weekPortions.get(weekPortions.size());
        RunningSession lastCheckedSession = sessions.get(sessions.size() - 1);

        if (isSameWeek(lastCheckedSession.getStartTime().toLocalDate(), session.getStartTime().toLocalDate())) {
            sessions.add(session);
        } else {
            weekPortions.put(weekPortions.size() + 1, createNewPortion(session));
        }
    }

    private List<RunningSession> createNewPortion(RunningSession session) {
        List<RunningSession> newPortion = new ArrayList<>();
        newPortion.add(session);
        return newPortion;
    }

    /**
     * Weekly report generating
     *
     * @param sessions running sessions in one week
     * @return week report
     */
    private RunningSessionWeeklyReport generateReport(int weekNumber, List<RunningSession> sessions) {
        LocalDate anySessionDate = sessions.stream()
            .findAny()
            .get()
            .getStartTime()
            .toLocalDate();

        RunningSessionWeeklyReport report = new RunningSessionWeeklyReport();
        report.setTotalDistance(getTotalDistance(sessions));
        report.setWeekNumber(weekNumber);
        report.setAverageSpeed(getAverageSpeed(sessions));
        report.setWeekStart(getFirstDayOfWeek(anySessionDate));
        report.setWeekEnd(getLastDayOfWeek(anySessionDate));
        return report;
    }

    private int getTotalDistance(List<RunningSession> sessions) {
        return sessions.stream()
            .flatMapToInt(runningSession -> IntStream.of(runningSession.getDistance()))
            .sum();
    }

    private double getAverageSpeed(List<RunningSession> sessions) {
        Long size = (long) sessions.size();
        Long totalMillis = sessions.stream()
            .flatMapToLong(session -> LongStream.of(getTimeOfSessionInMillis(session)))
            .sum();
        return round(totalMillis.doubleValue() / size.doubleValue() / 1000000, 2);
    }


    private long getTimeOfSessionInMillis(RunningSession session) {
        return Duration.between(session.getStartTime(), session.getFinishTime()).toMillis();
    }

    /**
     * Code snippet from my first project
     *
     * @param value value
     * @param places number of characters after coma
     * @return rounded value
     */
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
