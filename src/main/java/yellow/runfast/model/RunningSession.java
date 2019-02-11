package yellow.runfast.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Running session data object
 *
 * @author Gorovtsov Alexander
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "running_sessions")
public class RunningSession extends BaseEntity {

    /**
     * Distance (meters)
     */
    @Column(name = "distance", nullable = false)
    private int distance;

    /**
     * Timestamp of start of running session
     */
    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    /**
     * Timestamp of finish of training session
     */
    @Column(name = "finish_time", nullable = false)
    private LocalDateTime finishTime;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


}
