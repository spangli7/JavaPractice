package exams.oo_practice.bath;

import java.time.LocalTime;

public class Guests {
    public LocalTime firstGuest;
    public LocalTime lastGuest;

    public Guests(LocalTime firstGuest, LocalTime lastGuest) {
        this.firstGuest = firstGuest;
        this.lastGuest = lastGuest;
    }
}
