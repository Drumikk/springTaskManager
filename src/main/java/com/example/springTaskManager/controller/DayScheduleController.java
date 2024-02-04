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
            //Передаём и тело запроса и параметр поисковой строки, мб можно сделать лучше
    public ResponseEntity createDaySchedule(@RequestBody DayScheduleEntity daySchedule,
                                            @RequestParam Long userId){
        try {
            return ResponseEntity.ok(dayScheduleService.createDaySchedule(daySchedule,userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    // ПОМЕНЯТЬ НА ЧТО_ТО НОРМАЛЬНОЕ!!!!!
    @PutMapping
    public ResponseEntity updateDaySchedule(@RequestParam Long id){
        try {
            return ResponseEntity.ok(dayScheduleService.updateDaySchedule(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
}
