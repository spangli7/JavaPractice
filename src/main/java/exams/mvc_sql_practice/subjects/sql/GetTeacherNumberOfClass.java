package exams.mvc_sql_practice.subjects.sql;

import common.sql.ConnectionPool;
import exams.mvc_sql_practice.subjects.modell.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetTeacherNumberOfClass {


    private static final String SELECT_TEACHER = "SELECT tanar, oraszam FROM ora_adatok WHERE tanar = ?";

    public List<Teacher> getTeacherNumberOfClass(String teacher){
        List<Teacher> getTeacher = new ArrayList<>();

        try {
            Connection con = ConnectionPool.getConnection();
            PreparedStatement stmt = con.prepareStatement(SELECT_TEACHER);

            stmt.setString(1, teacher);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                String name = rs.getString("tanar");
                int number = rs.getInt("oraszam");
                Teacher teacher1 = new Teacher(name,number);
                getTeacher.add(teacher1);
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return getTeacher;
    }

}
