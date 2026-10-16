
import com.lastma.data.models.Driver;
import com.lastma.data.models.Officer;
import com.lastma.data.models.Ticket;
import com.lastma.data.repositories.TicketRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketRepositoryImplTest {
    private TicketRepositoryImpl ticketRepository = new TicketRepositoryImpl();
    private Ticket ticket;

    @BeforeEach
    void setUp() {
        ticketRepository = new TicketRepositoryImpl();
        ticket = new Ticket();
    }

    @Test
    public void testThat_I_Can_Save_Ticket_And_Count_Increased_By_One() {
        assertEquals(0L, ticketRepository.count());
        Ticket ticket = new Ticket();
        ticketRepository.save(ticket);
        assertEquals(1L, ticketRepository.count());
    }
    @Test
    public void testThat_When_I_Add_Two_Ticket_Count_Becomes_Two() {
        assertEquals(0L, ticketRepository.count());
        Ticket ticketTwo = new Ticket();
        ticketRepository.save(ticketTwo);
        ticketRepository.save(ticket);
        assertEquals(2L, ticketRepository.count());
    }

    @Test
    public void testThat_I_Can_Save_A_TicketId() {
        ticketRepository.save(ticket);
        assertEquals(1, ticket.getId());
    }

    @Test
    public void testThat_A_Ticket_Can_Be_Found_By_Ticket_Id() {
        Ticket savedTicket = ticketRepository.save(ticket);
        int ticketId = savedTicket.getId();
        assertEquals(savedTicket, ticketRepository.findById(ticketId));
    }

    @Test
    public void test_That_I_Can_Find_All_Drivers(){

        Ticket ticketTwo = new Ticket();
        Ticket ticketThree = new Ticket();
        Ticket [] allTickets = {ticket, ticketTwo,ticketThree};
        for(Ticket ticket : allTickets){
            ticketRepository.save(ticket);
        }
        List<Ticket> foundTickets = ticketRepository.findAll();
        int count = 0;
        for(Ticket ticket : foundTickets){
            assertEquals(ticket, allTickets[count]);
            count++;
        }

    }

}
