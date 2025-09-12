/*
 * Clock.java
 * Author: Enrique A. Montero Candelario
 * Date: July 20, 2025
 * Purpose: Defines the Clock class with functions to manipulate and display 12- and 24-hour formats.
 */

public class Clock {
    private int hour;   // Hour value (0-23)
    private int minute; // Minute value (0-59)
    private int second; // Second value (0-59)

    /**
    Constructor initializes the clock with given hour, minute, and second.
    @param h int - initial hour (0-23)
    @param m int - initial minute (0-59)
    @param s int - initial second (0-59)
    */
    public Clock(int h, int m, int s) {
        this.hour = h;
        this.minute = m;
        this.second = s;
    }

    /**
    Adds one hour to the current time (wraps back to 0 after 23).
    */
    public void addHour() {
        hour = (hour + 1) % 24;
    }

    /**
    Adds one minute to the current time (rolls over to next hour if 60).
    */
    public void addMinute() {
        minute++;
        if (minute >= 60) {
            minute = 0;
            addHour();
        }
    }

    /**
    Adds one second to the current time (rolls over to next minute if 60).
    */
    public void addSecond() {
        second++;
        if (second >= 60) {
            second = 0;
            addMinute();
        }
    }

    /**
    Displays the time in 12-hour clock format with AM/PM notation.
    */
    public void display12HourClock() {
        int displayHour = hour % 12;
        if (displayHour == 0) displayHour = 12;
        String meridiem = (hour < 12) ? "AM" : "PM";

        System.out.printf("%27s%n", "12-Hour Clock");
        System.out.printf("%20s%02d:%02d:%02d %s%n", "", displayHour, minute, second, meridiem);
    }

    /**
    Displays the time in 24-hour clock format.
    */
    public void display24HourClock() {
        System.out.printf("%27s%n", "24-Hour Clock");
        System.out.printf("%20s%02d:%02d:%02d%n", "", hour, minute, second);
    }
}
