package com.isoft.reservation.controller;

import com.isoft.reservation.model.ReservationForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping({"home",""})
    public String displayHome(Model model){
        List<String> days=new ArrayList<>();
        days.add("Saturday");
        days.add("Monday");
        days.add("Wednesday");
        ReservationForm reservationForm=new ReservationForm();
        reservationForm.setDays(days);
        model.addAttribute("form",reservationForm);
        return "home";
    }

}
