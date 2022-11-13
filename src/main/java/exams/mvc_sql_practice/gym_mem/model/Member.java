package exams.mvc_sql_practice.gym_mem.model;

public class Member {

    public int id;
    public String name;
    public String address;
    public String telNumber;

    public Member(int id, String name, String address, String telNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.telNumber = telNumber;
    }

    public Member(String name, String address, String telNumber){
        this.name = name;
        this.address = address;
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Members "+ name + "\n";
    }
}
