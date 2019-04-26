package com.fazenda.streetMusicConcert.helper;

import com.fazenda.streetMusicConcert.util.TimeSlot;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class StaticDataProvider {

    public static TimeSlot provideValidTimeSlot() {
        LocalDateTime start = LocalDate.parse("2018-06-12").atTime(12, 0, 0);
        LocalDateTime stop = LocalDate.parse("2018-06-12").atTime(13, 0, 0);

        return new TimeSlot(start, stop);
    }

    public static TimeSlot provideDefaultValidTimeSlot() {
        LocalDateTime start = LocalDate.parse("2020-01-01").atTime(12, 0, 0);
        LocalDateTime stop = LocalDate.parse("2020-01-01").atTime(13, 0, 0);

        return new TimeSlot(start, stop);
    }
}