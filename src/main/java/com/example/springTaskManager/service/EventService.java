package com.example.springTaskManager.service;

import com.example.springTaskManager.entity.DayScheduleEntity;
import com.example.springTaskManager.entity.EventEntity;
import com.example.springTaskManager.exception.TimeIncorrectException;
import com.example.springTaskManager.repository.DayScheduleRepo;
import com.example.springTaskManager.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    public EventEntity createEvent(EventEntity event, Long dayScheduleId) throws TimeIncorrectException {
        DayScheduleEntity daySchedule = dayScheduleRepo.findById(dayScheduleId).get();
        event.setDayScheduleEntity(daySchedule);
        //Список наших промежутков, которые пересекаются с тем, который хотим задать и имеют такое же айди дня.
        //Если список пустой, то можем бронировать промежуток, если нет - просто возвращаем сущность ивента обратно + исключение
        List<EventEntity> eventEntitiesList = eventRepo.findByStartTimeLessThanEqualAndEndTimeGreaterThanEqualAndDayScheduleEntityId(event.getEndTime(),event.getStartTime(),dayScheduleId);
        if (eventEntitiesList.isEmpty()) {
            return eventRepo.save(event);
        }
        throw  new TimeIncorrectException("Некорректный промежуток времени");
    }
}
