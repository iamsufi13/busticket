package com.busticketmanagement.Ticket;


import com.busticketmanagement.Email.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    EmailService emailService;

    @PostMapping("/book")
    public String bookTicket(@RequestBody Ticket ticket) throws MessagingException, UnsupportedEncodingException {
        Ticket bookedTicket = ticketService.bookTicket(ticket);
    emailService.sendEmail(ticket.getEmail(), "Ticket Booked for " + bookedTicket.getName() ,bookedTicket);
        return "Booking Successful! Your ticket ID is " + bookedTicket.getId();
    }

}

