package com.project.rentAcar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * This class configures the scheduling capabilities for the Spring application.
 * It enables the scheduling of tasks using annotations such as @Scheduled.
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
}