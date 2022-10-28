package mvc.numbers.sql;

import mvc.numbers.model.QuizType;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class GetAllQuizType {

    private static final String QUIZ_TYPE_SQL = "SELECT * FROM quiz_type";

    public Map<Integer,String>  getAllQuizType (){
        Map<Integer,String>  quizType = new HashMap<>();

        try (Connection con = ConnectionPool.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(QUIZ_TYPE_SQL);

            while (rs.next()){

                QuizType type = new QuizType(rs.getInt("id"),rs.getString("name"));
                quizType.put(type.id,type.typeName);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    return quizType;
    }
}
