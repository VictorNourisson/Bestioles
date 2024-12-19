package com.example.species.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CronService {

    @Value("${cron.schedule}")
    private String cronSchedule; // Valeur lue depuis application.properties

    @Scheduled(cron = "${cron.schedule}") // Utilise la valeur du fichier properties
    public void executeTask() {
        System.out.println("Tâche exécutée à : " + LocalDateTime.now());
    }
} 