package com.lastma.data.repositories;

import com.lastma.data.models.Driver;
import com.lastma.data.models.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketRepositoryImpl implements TicketRepository {

    private List<Ticket> tickets = new ArrayList<>();
    private int numberOfTickets = 0;

    @Override
    public Ticket save(Ticket ticket) {
        ticket.setId(++numberOfTickets);
        tickets.add(ticket);
        return ticket;
    }

    @Override
    public long count() {
        return numberOfTickets;
    }

    @Override
    public Ticket findById(int id){
        for(Ticket ticket : tickets){
            if(ticket.getId()==id){
                return ticket;
            }
        }
        throw new IllegalArgumentException("Ticket with id" + id + "is not found");
    }


//    @Override
//    public Ticket findById(int Id) {
//        return null;
//    }

    @Override
    public List<Ticket> findAll() {
        return List.of();
    }

    @Override
    public void delete(int TicketId) {

    }

    @Override
    public void deleteAll() {
        tickets.clear();
        numberOfTickets = 0;
    }

}

