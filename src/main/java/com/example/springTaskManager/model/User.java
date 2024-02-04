package com.example.springTaskManager.model;

import com.example.springTaskManager.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

//Отдельный класс моделей для того чтобы не возвращать клиенту сущность User со всеми полями
public class User {
    private Long id;
    private String username;
    private String email;
    private List<DaySchedule> dayScheduleList;

    //Присвоение всех полей сущности к полям модели которую возвращаем
    public static User toModel(UserEntity entity){
        User model = new User();
        model.setEmail(entity.getEmail());
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setDayScheduleList(entity.getDaySchedule().stream().map(DaySchedule::toModel).collect(Collectors.toList()));
        return model;
    }


    public User() {
    }

    public List<DaySchedule> getDayScheduleList() {
        return dayScheduleList;
    }

    public void setDayScheduleList(List<DaySchedule> dayScheduleList) {
        this.dayScheduleList = dayScheduleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
