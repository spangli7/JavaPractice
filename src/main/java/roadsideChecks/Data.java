package roadsideChecks;
import java.time.LocalTime;

public class Data {
    private LocalTime localTime;
    private String licensePlateNumber;

    public Data(LocalTime localTime, String licensePlateNumber) {
        this.localTime = localTime;
        this.licensePlateNumber = licensePlateNumber;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }
}
