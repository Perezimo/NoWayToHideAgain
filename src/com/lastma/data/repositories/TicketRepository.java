package com.lastma.data.repositories;

import com.lastma.data.models.Officer;
import com.lastma.data.models.Ticket;

import java.util.List;

public interface TicketRepository {
        Ticket save (Ticket ticket);

        long count();
        Ticket findById(int Id);

        List<Ticket> findAll();

        void delete(int TicketId);
        void deleteAll();

}
