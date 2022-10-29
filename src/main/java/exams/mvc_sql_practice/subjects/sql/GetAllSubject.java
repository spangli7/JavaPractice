package exams.mvc_sql_practice.subjects.sql;

import common.sql.ConnectionPool;
import exams.mvc_sql_practice.subjects.modell.Subject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetAllSubject {

    private static final String SUBJECT_SQL = "SELECT * FROM ora_adatok;";

    public List<Subject> getAllSubject(){
        List<Subject> allSubject = new ArrayList<>();

        try {
            Connection con =  ConnectionPool.getConnection();
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(SUBJECT_SQL);

            while (rs.next()){
                String teacherName = rs.getString("tanar");
                String subject = rs.getString("tantargy");
                String department = rs.getString("osztaly");
                int numberOfLesson = rs.getInt("oraszam");

                Subject subject1 = new Subject(teacherName,subject,department,numberOfLesson);
                allSubject.add(subject1);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return allSubject;
    }
}
