package bath;

import java.time.LocalTime;

public class Time {
    int time6 = 0;
    int tim9 = 0;
    int time16 = 0;

    Time(){
    }

    public void setTime(LocalTime localTime){
        if(localTime.getHour() >= 6 && localTime.getHour() < 9 ){
        this.time6++;

        } else if(localTime.getHour() >= 9 && localTime.getHour() < 16 ){
        this.tim9++;

        } else if(localTime.getHour() >= 16 && localTime.getHour() < 20){
        this.time16++;
        }
    }
}
