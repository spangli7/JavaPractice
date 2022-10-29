package exams.mvc_sql_practice.numbers.sql;

import common.sql.ConnectionPool;
import exams.mvc_sql_practice.numbers.model.Question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetAllQuestion {

    private static final String QUESTIONS_SQL = "SELECT * FROM quiz_questions";

    public List<Question> getAllQuestions(){

        List<Question> allQuestions = new ArrayList<>();

        try (Connection con = ConnectionPool.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUESTIONS_SQL);

            while (rs.next()){

                Question question = new Question(rs.getInt("id"),
                                                rs.getString("question"),
                                                rs.getInt("answer"),
                                                rs.getInt("point"),
                                                rs.getInt("type_id"));

                allQuestions.add(question);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return allQuestions;
    }

}
