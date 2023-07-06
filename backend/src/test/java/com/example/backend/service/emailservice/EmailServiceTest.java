package com.example.backend.service.emailservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

public class EmailServiceTest {

    @Mock
    private JavaMailSender javaMailSender;

    private EmailService emailService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        emailService = new EmailService(javaMailSender);
    }

    @Test
    public void testSendMail() {
        String toEmail = "test@example.com";
        String subject = "test subject";
        String message = "test message";

        emailService.sendMail(toEmail, subject, message);

        ArgumentCaptor<SimpleMailMessage> mailMessageCaptor = ArgumentCaptor.forClass(SimpleMailMessage.class);
        verify(javaMailSender).send(mailMessageCaptor.capture());

        SimpleMailMessage sentMessage = mailMessageCaptor.getValue();
        assertEquals(toEmail, sentMessage.getTo()[0]);
        assertEquals(subject, sentMessage.getSubject());
        assertEquals(message, sentMessage.getText());
        assertEquals("signal.test.mail@mail.ru", sentMessage.getFrom());
    }
}
