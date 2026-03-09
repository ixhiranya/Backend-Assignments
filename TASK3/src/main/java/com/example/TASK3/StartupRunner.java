package com.example.TASK3;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
@Component
public class StartupRunner  {//implements CommandLineRunner
    @Value("${app.name}")
    private String appName;

//    @Override
//    public void run(String... args) throws Exception{
//        System.out.println("Application Name: "+ appName);
//    }
@PostConstruct
public void init() {
    System.out.println("Application Name: " + appName);
}
//TASK5
}
