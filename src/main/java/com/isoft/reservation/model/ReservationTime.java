package com.isoft.reservation.model;

import lombok.Getter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class ReservationTime {
    private List<LocalTime> availableTimes = new ArrayList<>();
}
