package com.example.springTaskManager.controller;

import com.example.springTaskManager.entity.DayScheduleEntity;
import com.example.springTaskManager.exception.DayScheduleAlreadyExistException;
import com.example.springTaskManager.service.DayScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/day_schedule")
public class DayScheduleController {
    @Autowired
    private DayScheduleService dayScheduleService;
    @PostMapping
    public ResponseEntity createDaySchedule(@RequestBody DayScheduleEntity daySchedule,
                                            @RequestParam Long userId){
        try {
            return ResponseEntity.ok(dayScheduleService.createDaySchedule(daySchedule, userId));

        }catch (DayScheduleAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        //Костыль, чтобы не выводилась ошибка при добавлении в БД,
        // потому что конфликт с Stream API, когда вызываем функцию
        // toModel при создании объекта распорядка дня
        catch (NullPointerException e) {
            return ResponseEntity.ok(daySchedule);
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла неизестная ошибка при создании распорядка дня");
        }
    }
    //ДОСТУП В Spring SECURITY должен быть ТОЛЬКО У ТОГО ЖЕ ПОЛЬЗОВАТЕЛЯ ЧТО СОЗДАЛ, ИЛИ У АДМИНА
    @PutMapping("/update")
    public ResponseEntity updateDaySchedule(@RequestBody DayScheduleEntity daySchedule,
                                            @RequestParam Long id){
        try {
            return ResponseEntity.ok(dayScheduleService.updateDaySchedule(daySchedule, id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteDaySchedule(Long id){
        try{
            dayScheduleService.delete(id);
            return ResponseEntity.ok().body("Day Schedule" + id + "Was deleted");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка при удалении пользователя");
        }
    }

}
