package com.example.springTaskManager.service;

import com.example.springTaskManager.entity.DayScheduleEntity;
import com.example.springTaskManager.entity.EventEntity;
import com.example.springTaskManager.repository.DayScheduleRepo;
import com.example.springTaskManager.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private DayScheduleRepo dayScheduleRepo;

    public EventEntity createEvent(EventEntity event, Long dayScheduleId){
        DayScheduleEntity daySchedule = dayScheduleRepo.findById(dayScheduleId).get();
        event.setDayScheduleEntity(daySchedule);
        return eventRepo.save(event);
        //Проверка на то что наше время не заходит за рамки уже существующих интервалов ДЛЯ ЭТОГО РАСПОРЯДКА
//        if (eventRepo.fin)
    }
}
