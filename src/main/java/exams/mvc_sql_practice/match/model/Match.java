package exams.mvc_sql_practice.match.model;

public class Match {
    public int homTeamId;
    public int oppTeamId;
    public int round;
    public int homGoals;
    public int oppGoals;
    public int halfTimeHomGoals;
    public int halfTimeOppGoals;

    public Match(int homTeamId, int oppTeamId, int round, int homGoals, int oppGoals, int halfTimeHomGoals, int halfTimeOppGoals) {
        this.homTeamId = homTeamId;
        this.oppTeamId = oppTeamId;
        this.round = round;
        this.homGoals = homGoals;
        this.oppGoals = oppGoals;
        this.halfTimeHomGoals = halfTimeHomGoals;
        this.halfTimeOppGoals = halfTimeOppGoals;
    }

    @Override
    public String toString() {
        return "Match{" +
                "homTeamId=" + homTeamId +
                ", oppTeamId=" + oppTeamId +
                ", round=" + round +
                ", homGoals=" + homGoals +
                ", oppGoals=" + oppGoals +
                ", halfTimeHomGoals=" + halfTimeHomGoals +
                ", halfTimeOppGoals=" + halfTimeOppGoals +
                '}';
    }
}
