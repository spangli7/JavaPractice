package exams.mvc_sql_practice.gym_mem.model;

public enum Commands {

    ADD("add"),
    BUY("buy"),
    USER("user"),
    TICKET("ticket"),
    UPDATE("update"),
    CHECK("check"),
    GUESTS("guest");

    public String code;

    Commands(String code) {
        this.code = code;
    }

    public static Commands getCommands(String code){
        for (Commands type : values()) {
            if( type.code.equals(code) ){
                return type;
            }
        }
        return null;
    }



}
