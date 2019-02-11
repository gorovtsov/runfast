package yellow.runfast.test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

import yellow.runfast.model.RunningSession;
import yellow.runfast.model.User;
import yellow.runfast.repository.RunningSessionRepository;
import yellow.runfast.service.RunningReportService;
import yellow.runfast.service.impl.RunningReportServiceImpl;

/**
 * Test for {@link RunningReportService}
 *
 * @author Alexander Gorovtsov
 */
@RunWith(MockitoJUnitRunner.class)
public class ReportServiceTest {

    @Mock
    RunningSessionRepository repository;

    @InjectMocks
    RunningReportServiceImpl reportService;

    @Test
    public void repositoryTest() {
        User user = generateUser();
        when(repository.findByUser(user)).thenReturn(generateRunningSessions());
        Assert.assertThat(repository.findByUser(user).size(), is(4));
    }

    /**
     * Checks if 8-day training range can produce only two weekly reports
     */
    @Test
    public void reportGenerationTest() {
        User user = generateUser();
        when(repository.findByUser(user)).thenReturn(generateRunningSessions());

        Assert.assertThat(reportService.getAllReportsByUser(user).size(), is(2));
    }

    private List<RunningSession> generateRunningSessions() {
        List<RunningSession> sessions = new ArrayList<>();

        LocalDateTime initialStartDate = LocalDateTime.of(2019, 2, 7, 12, 30);
        LocalDateTime initialEndDate = LocalDateTime.of(2019, 2, 7, 13, 30);

        sessions.add(new RunningSession(10000, initialStartDate, initialEndDate, generateUser()));
        sessions.add(new RunningSession(11030, initialStartDate.plusDays(2), initialEndDate.plusDays(2), generateUser()));
        sessions.add(new RunningSession(9060, initialStartDate.plusDays(4), initialEndDate.plusDays(4), generateUser()));
        sessions.add(new RunningSession(9010, initialStartDate.plusDays(6), initialEndDate.plusDays(6), generateUser()));

        return sessions;
    }

    private User generateUser() {
        return new User("testLogin", "testPassword", "Alexander", "Gorovtsov");

    }

}
