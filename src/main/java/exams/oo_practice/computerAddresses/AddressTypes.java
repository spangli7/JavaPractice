package exams.oo_practice.computerAddresses;

public enum AddressTypes {

    DOKUMENTACIOS( "dokumentációs"),
    EGYEDI( "egyedi cim"),
    HELYI( "helyi");

    String kod;

     AddressTypes(String kod){
        this.kod = kod;
    }

    public AddressTypes getAddressType(String kod){
        for (AddressTypes types : values()) {
            if(types.kod.equals(kod)){
                return types;
            }
        }
        return null;
    }
}
