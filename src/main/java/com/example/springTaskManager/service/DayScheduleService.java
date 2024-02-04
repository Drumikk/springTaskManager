package com.example.springTaskManager.service;

import com.example.springTaskManager.entity.DayScheduleEntity;
import com.example.springTaskManager.entity.UserEntity;
import com.example.springTaskManager.model.DaySchedule;
import com.example.springTaskManager.repository.DayScheduleRepo;
import com.example.springTaskManager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DayScheduleService {
    @Autowired
    private DayScheduleRepo dayScheduleRepo;
    @Autowired
    private UserRepo userRepo;
    public DaySchedule createDaySchedule(DayScheduleEntity daySchedule, Long userid){
        UserEntity user = userRepo.findById(userid).get();
        daySchedule.setUser(user);
        return DaySchedule.toModel(dayScheduleRepo.save(daySchedule));
    }
    public DaySchedule updateDaySchedule(Long id){
        DayScheduleEntity daySchedule = dayScheduleRepo.findById(id).get();
        daySchedule.setDate(LocalDate.now());
        return DaySchedule.toModel(dayScheduleRepo.save(daySchedule));

    }
}
