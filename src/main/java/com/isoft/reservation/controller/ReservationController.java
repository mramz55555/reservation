package com.isoft.reservation.controller;

import com.isoft.reservation.dao.ReservationDAO;
import com.isoft.reservation.model.ReservationDay;
import com.isoft.reservation.model.ReservationTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;
import java.util.Objects;

@Controller
public class ReservationController {
    private ReservationDAO dao;

    public ReservationController(ReservationDAO dao) {
        this.dao = dao;
    }

    @GetMapping
    public String showMain(Model model) {
        model.addAttribute("activeDays", new ReservationDay());
        model.addAttribute("errorMessage", "");
        return "home";
    }

    @PostMapping("submit")
    public String submit(Model model, @ModelAttribute("activeDays") ReservationDay reservationDay,
                         @ModelAttribute("errorMessage") String errorMessage) {
        if (reservationDay.getTheDay() == null) {
            model.addAttribute("errorMessage", "The day can not be empty");
            return "home";
        }
        ReservationTime times = new ReservationTime();
        LocalTime basTime = LocalTime.of(9, 0, 0);
        for (int i = 1; i < 5; i++)
            times.getAvailableTimes().add(basTime.plusHours(2 * i));
        model.addAttribute("times", times);
        model.addAttribute("errorMessage", "");
        return "reservation-times";
    }

    @PostMapping("submitTime")
    public String submitTime(Model model, @ModelAttribute("times") ReservationTime reservationTime) {

        if (reservationTime.getAvailableTimes().size() != 1) {
            model.addAttribute("errorMessage", "Only specify one time");
            return "reservation-times";
        }

        LocalTime time = reservationTime.getAvailableTimes().stream().filter(Objects::nonNull).toList().get(0);
        if (dao.isReserved(time)) {
            model.addAttribute("error", "this time is reserved");
            return "reservation-times";
        }
        dao.persist(time);
        return "home";
    }
    }

