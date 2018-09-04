package application.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeSlot {

    private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDateTime start;
    private LocalDateTime stop;

    public TimeSlot(LocalDateTime start, LocalDateTime stop) {
        this.start = start;
        this.stop = stop;
    }

    private String getStartTime() {
        return start.format(timeFormatter);
    }

    private String getStopTime() {
        return stop.format(timeFormatter);
    }

    private String getLength() {
        long generalSeconds = (int) ChronoUnit.SECONDS.between(start, stop);

        int seconds = (int) generalSeconds%60;
        int minutes = (int) generalSeconds/60;
        int hours = minutes/60;
        minutes = minutes%60;

        return hours + ":" + minutes + ":" + seconds;
    }

    private String getDate() {
        return start.format(dateFormatter);
    }

    @Override
    public String toString() {
        return getStartTime() + " -> " + getStopTime() + " = " + getLength() + " (" + getDate() + ")";
    }
}
