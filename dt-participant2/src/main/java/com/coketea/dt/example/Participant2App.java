package com.coketea.dt.example;

import com.coketea.dt.agent.annotation.EnableDTTransactionManager;
import com.coketea.dt.client.annotation.EnableDTClient;
import com.oqiji.boot.dubbo.DubboScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@DubboScan("com.coketea.dt.example.participant2")
@EnableTransactionManagement
@EnableDTTransactionManager
@EnableDTClient
public class Participant2App {
    public static void main(String[] args) {
        SpringApplication.run(Participant2App.class, args);
    }
}
