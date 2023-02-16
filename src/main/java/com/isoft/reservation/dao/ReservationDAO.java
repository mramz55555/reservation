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

    public void insert(LocalTime time){
        entityManager.createNativeQuery("insert into reserved_date (reserved_date) values ("+time+")");
    }

    public boolean isReserved(LocalTime time){
        return entityManager.createQuery("select r.reserved_date from reserved_days").getSingleResult()!=null;
    }
}
