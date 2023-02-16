package com.isoft.reservation.controller;

import com.isoft.reservation.dao.ReservationDAO;
import com.isoft.reservation.model.ReservationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ReservationController {
    private ReservationDAO dao;

    public ReservationController(ReservationDAO dao) {
        this.dao = dao;
    }

    @PostMapping("submit")
    public String submit(Model model) {
        ReservationForm form = ((ReservationForm) model.getAttribute("form"));
        if (form.getDays().isEmpty()) {
            model.addAttribute("error", "The day can not empty");
            return "home";
        }
        List<LocalTime> times = new ArrayList<>();
        LocalTime basTime = LocalTime.of(9, 0, 0);
        for (int i = 1; i < 5; i++)
            times.add(basTime.plusHours(2 * i));
        form.setTimes(times);
        model.addAttribute("times", times);
        return "reservation-times";
    }


    @PostMapping("submitTime")
    public String submitTime(Model model) {
        ReservationForm form = ((ReservationForm) model.getAttribute("form"));
        List<LocalTime> times = form.getTimes();
        if (times.size() != 1) {
            model.addAttribute("error", "specify the time");
            return "reservation-times";
        }

        LocalTime time = times.get(0);
        if (dao.isReserved(time)) {
            model.addAttribute("error", "this time is reserved");
            return "reservation-times";
        }
        return "home";
    }
}
