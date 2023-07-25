package com.example.backend;

import com.example.backend.repository.RestaurantRepository;
import com.example.backend.telegrambot.TelegramBotApplication;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.function.Supplier;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class BackendApplication {

    final RestaurantRepository repository;
    private final TelegramBotApplication telegramBot;
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

//    @PostConstruct
//    public void init(){
//        try { //Запускаем телеграмм бота
//            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//            botsApi.registerBot(telegramBot);
//            log.debug("Telegram bot registered successfully.");
//        } catch (TelegramApiException e) {
//            log.error("Error occurred while registering Telegram bot: {}", e.getMessage());
//        }
//        repository.findAll();
//    }

}

