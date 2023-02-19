package com.isoft.reservation.dao;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.time.LocalTime;

@Component
public class ReservationDAO {
    private EntityManager entityManager;

    public ReservationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public boolean isReserved(LocalTime time){
        return entityManager.createQuery("select r from reserved_days r where r.reserved_dat="+time).getSingleResult() != null;
    }
}
