package exams.mvc_sql_practice.gym_mem.dao.sql;



import exams.mvc_sql_practice.gym_mem.dao.TicketTypeDao;
import exams.mvc_sql_practice.gym_mem.model.TicketType;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class GetTicketType implements TicketTypeDao {

    private static final String SQL_SELECT = "SELECT * FROM gym_ticket_type";
    private static final String SQL_INSERT = "INSERT INTO gym_ticket_type (name, price, duration_in_days) values(?,?,?)";
    private static final String SQL_UPDATE = "UPDATE gym_ticket_type SET price = ? AND duration_in_days = ? WHEN id = ?";


    @Override
    public Map<Integer, TicketType> getTicketType() {
        Map<Integer, TicketType> ticketTypes = new HashMap<>();

        try (Connection conn =  ConnectionPool.getConnection()) {

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(SQL_SELECT);

            while(rs.next()){

                TicketType t = getTicketType(rs);
                ticketTypes.put(t.id,t);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ticketTypes;

    }

    private TicketType getTicketType ( ResultSet rs) throws SQLException {
        return new TicketType( rs.getInt("id"), rs.getString("name"),
                                rs.getInt("price"), rs.getInt("duration_in_days"));
    }



    @Override
    public void saveTicketType(TicketType type) {

        try (Connection conn =  ConnectionPool.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
             stmt.setString(1,type.name);
             stmt.setInt(2,type.price);
             stmt.setInt(3,type.durationInDays);

             stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public void updateTicketType(TicketType type) {
        try (Connection conn =  ConnectionPool.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SQL_UPDATE);
             stmt.setInt(1, type.price);
             stmt.setInt(2,type.durationInDays);
             stmt.setInt(3,type.id);

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
