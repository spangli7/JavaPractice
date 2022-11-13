package exams.mvc_sql_practice.gym_mem.dao.sql;




import exams.mvc_sql_practice.gym_mem.dao.MemberDao;
import exams.mvc_sql_practice.gym_mem.model.Member;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GetMembers implements MemberDao {

    private static final String SQL_SELECT = "SELECT * FROM gym_member";
    private static final String SQL_INSERT = "INSERT INTO gym_member (name, address, tel_number)" +
                                                                    "VALUES (?, ?, ?);";


    @Override
    public Map<Integer, Member> getMembers() {
        Map<Integer, Member> members = new HashMap<>();

        try (Connection conn =  ConnectionPool.getConnection()) {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL_SELECT);

            while(rs.next()){

               Member m = getMember(rs);
               members.put(m.id,m);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return members;
    }

        private Member getMember(ResultSet rs) throws SQLException{
           return new Member(rs.getInt("id"), rs.getString("name"),
                             rs.getString("address"), rs.getString("tel_number"));
        }





    @Override
    public void saveMember(Member member) {
        try (Connection conn =  ConnectionPool.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, member.name);
            stmt.setString(2, member.address);
            stmt.setString(3, member.telNumber);

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
