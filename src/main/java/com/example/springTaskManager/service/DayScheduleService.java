package com.example.springTaskManager.service;

import com.example.springTaskManager.entity.DayScheduleEntity;
import com.example.springTaskManager.entity.UserEntity;
import com.example.springTaskManager.exception.DayScheduleNotFoundException;
import com.example.springTaskManager.exception.UserNotFoundException;
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
    //ДОСТУП В SECURITY ТОЛЬКО У ТОГО ЖЕ ПОЛЬЗОВАТЕЛЯ ЧТО СОЗДАЛ, ИЛИ У АДМИНА
    public DaySchedule updateDaySchedule(DayScheduleEntity daySchedule, Long id){
        DayScheduleEntity scheduleEntity = dayScheduleRepo.findById(id).get();
        scheduleEntity.setDate(daySchedule.getDate());
        return DaySchedule.toModel(dayScheduleRepo.save(scheduleEntity));
    }
    public void delete(Long id) throws DayScheduleNotFoundException {
        DayScheduleEntity entity = dayScheduleRepo.findById(id).get();
        if (entity.getId().equals(null)){
            throw new DayScheduleNotFoundException("Такого распорядка дня не найдено");
        }
        dayScheduleRepo.deleteById(id);
    }
}
