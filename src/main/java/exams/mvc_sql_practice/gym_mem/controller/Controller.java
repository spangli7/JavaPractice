package exams.mvc_sql_practice.gym_mem.controller;


import exams.mvc_sql_practice.gym_mem.dao.MemberDao;
import exams.mvc_sql_practice.gym_mem.dao.TicketTypeDao;
import exams.mvc_sql_practice.gym_mem.dao.sql.*;
import exams.mvc_sql_practice.gym_mem.model.*;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Controller {

    MemberDao memberDao = new GetMembers();
    TicketTypeDao ticketTypeDao = new GetTicketType();

    Map<Integer, Member> members;
    Map<Integer, TicketType> ticketTypes;
    Map<Integer, Ticket> ticketByMemberId = new HashMap<>();


    public Map<Integer, Member> getGuests(){
        return getMembers();
    }

    public LocalDate checkTicketValidity(int memberId){
        Ticket ticket = ticketByMemberId.get(memberId);
        return ticket.to;
    }


    public void buyTicket(int ticketTypeId, int memberId ){
        Map<Integer, TicketType> ticketTypes = getTicketTypes();

        TicketType type = ticketTypes.get(ticketTypeId);
        Ticket ticket = new Ticket();

        ticket.userId = memberId;
        ticket.price = type.price;
        ticket.ticketType = type;
        ticket.from = LocalDate.now();
        ticket.to = LocalDate.now().plusDays(ticket.ticketType.durationInDays);

        ticketByMemberId.put(memberId,ticket);

        SaveTicket saveTicket = new SaveTicket();
        saveTicket.saveTicket(ticket);
    }


    public void addMember(Member newMember){
        memberDao.saveMember(newMember);
    }

    public void addTicket(TicketType newTicket){
        ticketTypeDao.saveTicketType(newTicket);
    }

    public void updateTicket(TicketType newTicket){
        ticketTypeDao.updateTicketType(newTicket);
    }


    private Map<Integer, Member> getMembers(){
        if(members == null){
            members = memberDao.getMembers();
        }
        return members;
    }

    private Map<Integer, TicketType> getTicketTypes(){
        if(ticketTypes == null){
            ticketTypes = ticketTypeDao.getTicketType();
        }
        return ticketTypes;
    }
}
