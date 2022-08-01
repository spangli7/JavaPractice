package bath;

public enum Department {
    OLTOZO(0),
    USZODA(1),
    SZAUNAK(2),
    GYOGYVIZ(3),
    STRAND(4);

    Integer code;

    Department(Integer code){
        this.code = code;
    }

    static Department getDepartment(Integer code){
        for (Department type : values()) {
            if(type.code.equals(code)){
                return type;
            }
        }
        return null;
    }


}
