package exams.mvc_sql_practice.match.model;

public class ShotAndGot {
    public int shot;
    public int got;

    public ShotAndGot( int shot, int got) {

        this.shot = shot;
        this.got = got;
    }

    @Override
    public String toString() {
        return "ShotAndGot{" +
                ", shot=" + shot +
                ", got=" + got +
                '}';
    }
}
