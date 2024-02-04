package com.example.springTaskManager.repository;

import com.example.springTaskManager.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.util.List;

public interface EventRepo extends CrudRepository<EventEntity, Long> {

    //Находим методом все записи в БД, в которых стартовое
    // время интервала меньше переданного конечного времени
    // и конечное время больше переданного стартового и айди дня равен переданному.
   List<EventEntity> findByStartTimeLessThanEqualAndEndTimeGreaterThanEqualAndDayScheduleEntityId(LocalTime endTime, LocalTime startTime,Long id);

}
