package exams.oo_practice.fence;

public class StreetData {
    private int houseNumber;
    private boolean isOdd;
    private int length;
    private String color;

    static int evenCounter = 2;
    static int oddCounter = 1;

    public StreetData( int side, int length, String color) {
        this.isOdd = side == 0;
        this.length = length;
        this.color = color;

        this.houseNumber = isOdd ? evenCounter : oddCounter;

        if(isOdd){
            evenCounter += 2;
        } else{
            oddCounter += 2;
        }
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public boolean isOdd() {
        return isOdd;
    }

    public void setOdd(boolean odd) {
        this.isOdd = odd;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
