package exams.oo_practice.courier;

public enum Amount {
    OTSZAZ(0,3,500),
    HETSZAZ(2,6,700),
    KILENCSZAZ(5,11,900),
    EZERNEGYSZAZ(10,21,1400),
    KETTOEZER(20,Integer.MAX_VALUE,2000);

    int km;
    int maxKm;
    int osszeg;

    Amount(int km, int maxKm, int osszeg) {
        this.km = km;
        this.maxKm = maxKm;
        this.osszeg = osszeg;
    }

    public static int getAmount(int km){
        for ( Amount amount : values() ) {
            if(km > amount.km && km < amount.maxKm){
                return amount.osszeg;
            }
        }
        return 0;
    }
}
