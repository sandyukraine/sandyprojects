package com.fazenda.streetMusicConcert.util;

import com.fazenda.streetMusicConcert.util.TimeSlot;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.Assert.*;

public class TimeSlotTest {

    @Test
    public void returnsCorrectPeriod() {
        LocalDateTime start = LocalDate.parse("2018-06-12").atTime(12, 0, 0);
        LocalDateTime stop = LocalDateTime.of(2018, Month.JUNE, 12, 13, 30);

        String expectedTimeSlotString = "12:00:00 -> 13:30:00 = 1:30:0 (2018-06-12)";
        String actualTimeSlotString = new TimeSlot(start, stop).toString();

        assertEquals(expectedTimeSlotString, actualTimeSlotString);
    }
}
