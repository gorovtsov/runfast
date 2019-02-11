package yellow.runfast.service;

import java.util.List;

import yellow.runfast.model.RunningSessionWeeklyReport;
import yellow.runfast.model.User;

/**
 * Report generation service
 *
 * @author Alexander Gorovtsov
 */
public interface RunningReportService {

    List<RunningSessionWeeklyReport> getAllReportsByUser(User user);

}
