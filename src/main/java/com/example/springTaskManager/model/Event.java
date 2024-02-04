package com.example.springTaskManager.model;

import com.example.springTaskManager.entity.EventEntity;

import java.time.LocalTime;

public class Event {
    private Long id;
    private String eventName;
    private String eventDescription;
    private LocalTime startTime;
    private LocalTime endTime;

    public static Event toModel(EventEntity entity){
        Event model = new Event();
        model.setEndTime(entity.getEndTime());
        model.setId(entity.getId());
        model.setEventDescription(entity.getEventDescription());
        model.setStartTime(entity.getStartTime());
        model.setEventName(entity.getEventName());
        return model;
    }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}
