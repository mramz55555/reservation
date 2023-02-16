package com.isoft.reservation.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class ReservationForm {
   private List<String> days;
   private List<LocalTime> times;
}
