package exams.oo_practice.bath;
import java.time.LocalTime;

public class BathData {
    private int personId;
    private Department location;
    private boolean entry;
    private LocalTime localTime;

    public BathData(int personId, Department location, boolean entry, LocalTime localTime) {
        this.personId = personId;
        this.location = location;
        this.entry = entry;
        this.localTime = localTime;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Department getLocation() {
        return location;
    }

    public void setLocation(Department location) {
        this.location = location;
    }

    public boolean isEntry() {
        return entry;
    }

    public void setEntry(boolean entry) {
        this.entry = entry;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
}
