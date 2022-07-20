package expedition;

public class RadioData {
    private int day;
    private int radioAmateur;
    private String message;

    public RadioData(int day, int radioAmateur, String message) {
        this.day = day;
        this.radioAmateur = radioAmateur;
        this.message = message;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getRadioAmateur() {
        return radioAmateur;
    }

    public void setRadioAmateur(int radioAmateur) {
        this.radioAmateur = radioAmateur;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
