package auditorium;

public class Seat {
    private boolean isBooked;
    private Price priceCategory;

    public Seat(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public Price getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(Price priceCategory) {
        this.priceCategory = priceCategory;
    }

    @Override
    public String toString() {
        return  isBooked + " : " + priceCategory;
    }
}
