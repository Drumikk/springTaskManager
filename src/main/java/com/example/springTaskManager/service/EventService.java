package com.example.springTaskManager.service;

import com.example.springTaskManager.entity.DayScheduleEntity;
import com.example.springTaskManager.entity.EventEntity;
import com.example.springTaskManager.exception.StartTimeIncorrectException;
import com.example.springTaskManager.repository.DayScheduleRepo;
import com.example.springTaskManager.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private DayScheduleRepo dayScheduleRepo;

//    public EventEntity createEvent(EventEntity event, Long dayScheduleId){
//        DayScheduleEntity daySchedule = dayScheduleRepo.findById(dayScheduleId).get();
//        event.setDayScheduleEntity(daySchedule);
//        return eventRepo.save(event);
//        //Проверка на то что наше время не заходит за рамки уже существующих интервалов ДЛЯ ЭТОГО РАСПОРЯДКА
////        if (eventRepo.fin)
//
//
//    }
    public EventEntity createEvent(EventEntity event, Long dayScheduleId) throws StartTimeIncorrectException {
        DayScheduleEntity daySchedule = dayScheduleRepo.findById(dayScheduleId).get();
        event.setDayScheduleEntity(daySchedule);
//        if ((eventRepo.findByStartTime(event.getStartTime()) != null) && (eventRepo.findByDayScheduleEntity_Id(dayScheduleId)!=null )
//                &&(eventRepo.findByStartTime(event.getStartTime())) > event.getStartTime()
//        {
//            throw  new StartTimeIncorrectException("Некорректное стартовое время");
//        }
        List<EventEntity> eventEntitiesList = eventRepo.findAllByStartTimeAndAndId(event.getStartTime(), dayScheduleId);
        if (eventEntitiesList.isEmpty()) {
            return eventRepo.save(event);
        }
        return event;
    }
}
