package com.coketea.dt.example;

import com.coketea.dt.agent.annotation.EnableDTTransactionManager;
import com.coketea.dt.client.annotation.EnableDTClient;
import com.oqiji.boot.dubbo.DubboScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@DubboScan("com.coketea.dt.example.participant1")
@EnableDTClient
@EnableDTTransactionManager
public class Participant1App {
    public static void main(String[] args) {
        SpringApplication.run(Participant1App.class, args);
    }
}
