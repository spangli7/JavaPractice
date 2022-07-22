package elections;

public enum PartiesType {
    GYUMOLCSEVOK("GYEP"),
    HUSEVOK("HEP"),
    TEJIVOK("TISZ"),
    ZOLDSEGEVOK("ZEP"),
    FUGGETLENEK("-");

    String kod;

    PartiesType(String kod){
        this.kod = kod;
    }

    public static PartiesType getParties(String kod){
        for(PartiesType type : values() ) {
            if(type.kod.equals(kod)){
                return type;
            }
        }
        return null;
    }
}


