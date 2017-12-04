package com.coketea.dt.example.participant1;

import com.oqiji.boot.dubbo.DubboScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@DubboScan("com.coketea.dt.example.participant1")
public class Participant1App {
    public static void main(String[] args) {
        SpringApplication.run(Participant1App.class, args);
    }
}
