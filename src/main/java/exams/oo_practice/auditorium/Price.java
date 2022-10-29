package exams.oo_practice.auditorium;

public enum Price {
    EGY(1,1500),
    KETTO(2,2000),
    HAROM(3,3000),
    NEGY(4,4000),
    OT(5,5000);

    Integer number;
    Integer price;

    Price(int number, int price){
        this.number = number;
        this.price = price;
    }

    public static Price getPrice(int number ) {

        for (Price par : values()) {
            if(par.number.equals(number)){
                return par;
            }
        }
        return null;
    }
}
