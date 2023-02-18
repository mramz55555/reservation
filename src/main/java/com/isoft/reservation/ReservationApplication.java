package com.isoft.reservation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;

@SpringBootApplication
public class ReservationApplication {
    public static void main(String[] args) {
        SpringApplication.run(ReservationApplication.class, args);
    }

}

class Main {
    public static void main(String[] args) {
        System.out.println(LocalTime.parse("13:00"));
    }
}
