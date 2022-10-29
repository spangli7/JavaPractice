package exams.mvc_sql_practice.match.sql;



import common.sql.ConnectionPool;
import exams.mvc_sql_practice.match.model.Match;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetAllMatchOfRound {

    private static final String MATCH_ROUND_SQL = " SELECT * FROM foci_match;";

    public List<Match> getAllMatchOfRound () {
        List<Match> allMatch = new ArrayList<>();

        try ( Connection con = ConnectionPool.getConnection()) {

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(MATCH_ROUND_SQL);

            while (rs.next()) {


                Match match = new Match(rs.getInt("home_team_id"),
                        rs.getInt("opp_team_id"),
                        rs.getInt("round"),
                        rs.getInt("home_goals"),
                        rs.getInt("opp_goals"),
                        rs.getInt("half_time_home_goals"),
                        rs.getInt("half_time_opp_goals"));

                allMatch.add(match);
            }
        } catch (SQLException throwables) {
            System.out.println("baj van ");
            throwables.printStackTrace();
        }

        return allMatch;
    }


}
