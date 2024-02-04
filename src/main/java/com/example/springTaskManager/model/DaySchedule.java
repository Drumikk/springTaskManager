package com.example.springTaskManager.model;

import com.example.springTaskManager.entity.DayScheduleEntity;
import com.example.springTaskManager.entity.EventEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class DaySchedule {
    private Long id;
    private LocalDate date;
    private List<Event> eventList;
    public static DaySchedule toModel(DayScheduleEntity entity){
        DaySchedule model = new DaySchedule();
        model.setDate(entity.getDate());
        model.setId(entity.getId());
        model.setEventList(entity.getEvent().stream().map(Event::toModel).collect(Collectors.toList()));
        return model;
    }

    public DaySchedule() {
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
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
