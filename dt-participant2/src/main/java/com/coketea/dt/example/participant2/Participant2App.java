package com.coketea.dt.example.participant2;

import com.oqiji.boot.dubbo.DubboScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboScan("com.coketea.dt.example.participant2")
public class Participant2App {
    public static void main(String[] args) {
        SpringApplication.run(Participant2App.class, args);
    }
}
