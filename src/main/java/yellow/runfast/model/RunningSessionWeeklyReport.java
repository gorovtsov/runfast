package yellow.runfast.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Running session weekly report
 *
 * @author Alexander Gorovtsov
 */
@Getter
@Setter
@NoArgsConstructor
public class RunningSessionWeeklyReport {

    private int weekNumber;

    private int totalDistance;

    private double averageSpeed;

    private LocalDate weekStart;

    private LocalDate weekEnd;

}
