package yellow.runfast.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class
 *
 * @author Alexander Gorovtsov
 */
public class DateUtils {

    private static final Map<DayOfWeek, Integer> INDEXED_DAYS;

    static {
        INDEXED_DAYS = new HashMap<>();
        INDEXED_DAYS.put(DayOfWeek.MONDAY, 1);
        INDEXED_DAYS.put(DayOfWeek.TUESDAY, 2);
        INDEXED_DAYS.put(DayOfWeek.WEDNESDAY, 3);
        INDEXED_DAYS.put(DayOfWeek.THURSDAY, 4);
        INDEXED_DAYS.put(DayOfWeek.FRIDAY, 5);
        INDEXED_DAYS.put(DayOfWeek.SATURDAY, 6);
        INDEXED_DAYS.put(DayOfWeek.SUNDAY, 7);

    }

    public static LocalDate getFirstDayOfWeek(LocalDate date) {
        return date.minusDays(INDEXED_DAYS.get(date.getDayOfWeek()) - INDEXED_DAYS.get(DayOfWeek.MONDAY));
    }

    public static LocalDate getLastDayOfWeek(LocalDate date) {
        return date.plusDays(INDEXED_DAYS.get(DayOfWeek.SUNDAY) - INDEXED_DAYS.get(date.getDayOfWeek()));
    }

    public static boolean isSameWeek(LocalDate firstDate, LocalDate secondDate) {
        int daysToSunday = getRangeToNearestSunday(firstDate);

        return !secondDate.isAfter(firstDate.plusDays(daysToSunday));
    }

    private static int getRangeToNearestSunday(LocalDate date) {
        return INDEXED_DAYS.get(DayOfWeek.SUNDAY) - INDEXED_DAYS.get(date.getDayOfWeek());
    }

}
