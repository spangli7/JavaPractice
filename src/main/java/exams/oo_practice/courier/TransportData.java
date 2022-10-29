package exams.oo_practice.courier;

public class TransportData implements Comparable<TransportData> {
    private int day;
    private int deliveryNumber;
    private int km;
    private int amount;

    public TransportData(int day, int deliveryNumber, int km, int amount) {
        this.day = day;
        this.deliveryNumber = deliveryNumber;
        this.km = km;
        this.amount = amount;
    }

    public int getDayNumber() {
        return day;
    }

    public void setDayNumber(int dayNumber) {
        this.day = dayNumber;
    }

    public int getDeliveryNumber() {
        return deliveryNumber;
    }

    public void setDeliveryNumber(int deliveryNumber) {
        this.deliveryNumber = deliveryNumber;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }



    public int compareTo(TransportData other) {
        if( this.day == other.day){
            return Integer.compare(this.deliveryNumber, other.deliveryNumber);
        }
        return Integer.compare(this.day,other.day) ;
    }
}
