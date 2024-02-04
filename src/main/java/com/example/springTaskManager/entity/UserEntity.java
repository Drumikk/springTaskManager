package com.example.springTaskManager.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;

//Сущность пользователя
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @NonNull
    @Column(unique = true)
    private String email;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<DayScheduleEntity> daySchedule;

    public UserEntity() {
    }

    public List<DayScheduleEntity> getDaySchedule() {
        return daySchedule;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
