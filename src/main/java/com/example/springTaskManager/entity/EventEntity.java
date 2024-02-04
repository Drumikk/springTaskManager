package com.example.springTaskManager.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class EventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private String eventDescription;
    @Temporal(TemporalType.TIME)
    @Column(unique = true)
    private LocalTime startTime;
    @Temporal(TemporalType.TIME)
    @Column(unique = true)
    private LocalTime endTime;
    @ManyToOne
    @JoinColumn(name = "day_schedule_id")
    private DayScheduleEntity dayScheduleEntity;

    public EventEntity() {
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

    public DayScheduleEntity getDayScheduleEntity() {
        return dayScheduleEntity;
    }

    public void setDayScheduleEntity(DayScheduleEntity dayScheduleEntity) {
        this.dayScheduleEntity = dayScheduleEntity;
    }
}
