package com.example.springTaskManager.model;

import com.example.springTaskManager.entity.DayScheduleEntity;

import java.time.LocalDate;

public class DaySchedule {
    private Long id;
    private LocalDate date;
    public static DaySchedule toModel(DayScheduleEntity entity){
        DaySchedule model = new DaySchedule();
        model.setDate(entity.getDate());
        model.setId(entity.getId());
        return model;
    }

    public DaySchedule() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
