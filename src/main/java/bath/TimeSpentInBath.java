package bath;

import java.time.LocalTime;

public class TimeSpentInBath {
    private LocalTime start;
    private LocalTime end;
    private int different;
    private int id;

    public TimeSpentInBath(LocalTime start, int id){
        this.start = start;
        this.id = id;
    }

    public TimeSpentInBath(LocalTime start, LocalTime end, int different) {
        this.start = start;
        this.end = end;
        this.different = different;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
        this.different = this.end.toSecondOfDay() - this.start.toSecondOfDay();
    }

    public int getDifferent() {
        return different;
    }

    public void setDifferent(int different) {
        this.different = different;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
