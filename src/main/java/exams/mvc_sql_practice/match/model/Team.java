package exams.mvc_sql_practice.match.model;

import java.util.Objects;

public class Team {
    public int teamId;
    public String name;


    public Team(int teamId, String team) {
        this.teamId = teamId;
        this.name = team;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", team='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return teamId == team.teamId && Objects.equals(name, team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teamId, name);
    }
}
