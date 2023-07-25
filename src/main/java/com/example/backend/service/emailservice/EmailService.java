package com.example.backend.service.emailservice;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Класс EmailService предоставляет методы для отправки электронных писем.
 */
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender javaMailSender;

    /**
     * Отправляет электронное письмо с заданными параметрами.
     *
     * @param toEmail адрес электронной почты получателя
     * @param subject тема письма
     * @param message текст сообщения
     */
    public void sendMail(String toEmail, String subject, String message) {

        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setTo(toEmail);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("signal.test.mail@mail.ru");

        javaMailSender.send(mailMessage);
    }
}
