package exams.mvc_sql_practice.gym_mem.dao;


import exams.mvc_sql_practice.gym_mem.model.TicketType;

import java.util.Map;

public interface TicketTypeDao {

    Map<Integer, TicketType> getTicketType();

    void saveTicketType(TicketType type);

    void updateTicketType(TicketType type);

}
