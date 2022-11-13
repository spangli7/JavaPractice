package exams.mvc_sql_practice.gym_mem.dao.sql;



import exams.mvc_sql_practice.gym_mem.dao.TicketDao;
import exams.mvc_sql_practice.gym_mem.model.Ticket;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SaveTicket implements TicketDao {
    private static final String SQL_INSERT = "INSERT INTO gym_ticket (user_id, ticket_type_id, price, from_date, to_date)" +
                                                "values(?,?,?,?,?)";


    @Override
    public void saveTicket(Ticket ticket) {
        try (Connection conn =  ConnectionPool.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1,ticket.userId);
            stmt.setInt(2,ticket.ticketType.id);
            stmt.setInt(3,ticket.price);
            stmt.setDate(4, Date.valueOf(ticket.from));
            stmt.setDate(5, Date.valueOf(ticket.to));

            stmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
