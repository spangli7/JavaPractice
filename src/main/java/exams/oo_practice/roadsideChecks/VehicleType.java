package exams.oo_practice.roadsideChecks;

public enum VehicleType {

    BUS("B"),
    TRUCK("K"),
    MOTORCYCLES("M"),
    CAR("G");

    String code;

    VehicleType(String kod){
        this.code = kod;
    }

    public static VehicleType getVehicleType(String kod){
        for (VehicleType type : values()) {
            if(type.code.equals(kod)){
                return type;
            }
        }
        return CAR;
    }
}
