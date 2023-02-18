package com.isoft.reservation.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDay {
    private String saturday, monday, wednesday;

    public String getTheDay() {
        return saturday != null ? saturday : monday != null ? monday : wednesday != null ? wednesday : null;
    }
}
