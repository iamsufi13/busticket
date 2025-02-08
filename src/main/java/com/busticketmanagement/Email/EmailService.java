package com.busticketmanagement.Email;

import com.busticketmanagement.Ticket.Ticket;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class EmailService {
    @Value("${spring.mail.username}")
    private String senderEmail;
    private JavaMailSender javaMailSender;

    @Autowired
    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public void sendSimpleEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

    @Async
    public void sendEmail(String to, String subject, Ticket ticket) throws MessagingException, UnsupportedEncodingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        String htmlContent = "<!DOCTYPE html><html lang=\"en\"><head><meta charset=\"UTF-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"><title>Ticket Booking Confirmation</title><style>body { font-family: Arial, sans-serif; background-color: #f7f7f7; padding: 20px; }.container { max-width: 600px; margin: auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1); }.header { text-align: center; color: #4CAF50; } .content { margin: 20px 0; } .footer { text-align: center; color: #999; font-size: 12px; margin-top: 30px; } .ticket-details { border: 1px solid #ddd; padding: 15px; border-radius: 8px; background-color: #f9f9f9; } .ticket-details td { padding: 8px; } .ticket-details th { background-color: #4CAF50; color: white; padding: 10px; }</style></head><body><div class=\"container\"><div class=\"header\"><h2>Ticket Booking Confirmation</h2><p>Thank you for booking with us, <strong>" + ticket.getName() + "</strong>!</p></div><div class=\"content\"><p>Your ticket has been successfully booked. Below are your booking details:</p><table class=\"ticket-details\"><tr><th>Ticket ID</th><td>" + ticket.getId() + "</td></tr><tr><th>Name</th><td>" + ticket.getName() + "</td></tr><tr><th>Email</th><td>" + ticket.getEmail() + "</td></tr><tr><th>Bus</th><td>" + ticket.getBus() + "</td></tr><tr><th>Payment Status</th><td>" + ticket.getPayment() + "</td></tr></table><p>We look forward to having you on board!</p></div><div class=\"footer\"><p>If you have any questions or concerns, feel free to contact us.</p><p>Best regards, <br> The Ticket Booking Team</p></div></div></body></html>";

        helper.setTo(to);
        helper.setText(htmlContent, true);
        helper.setSubject(subject);
        helper.setFrom(senderEmail,"Sufiyan");
        javaMailSender.send(mimeMessage);
    }


    @Async
    public void sendHtmlEmail(String to, String subject, String htmlContent) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);
        helper.setFrom(senderEmail);

        javaMailSender.send(mimeMessage);
    }
}
