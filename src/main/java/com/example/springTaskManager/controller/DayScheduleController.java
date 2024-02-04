package com.example.springTaskManager.controller;

import com.example.springTaskManager.entity.DayScheduleEntity;
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

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    //ДОСТУП В SECURITY ТОЛЬКО У ТОГО ЖЕ ПОЛЬЗОВАТЕЛЯ ЧТО СОЗДАЛ, ИЛИ У АДМИНА
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
