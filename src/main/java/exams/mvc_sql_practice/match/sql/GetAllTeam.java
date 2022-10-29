package exams.mvc_sql_practice.match.sql;

import common.sql.ConnectionPool;
import exams.mvc_sql_practice.match.model.Team;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class GetAllTeam {

    private static final String TEAM_SQL = "SELECT * FROM foci_team;";

    public Map<Integer, Team> getAllTeam(){

        Map<Integer,Team> teams = new HashMap<>();

        try (Connection con = ConnectionPool.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(TEAM_SQL);

            while (rs.next()){
                Team team = new Team(rs.getInt("id"), rs.getString("name"));
                teams.put(rs.getInt("id"), team);
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return teams;
    }

}
