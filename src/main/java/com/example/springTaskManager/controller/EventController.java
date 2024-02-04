package com.example.springTaskManager.controller;

import com.example.springTaskManager.entity.EventEntity;
import com.example.springTaskManager.exception.StartTimeIncorrectException;
import com.example.springTaskManager.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/event")
public class EventController {
    @Autowired
    private EventService eventService;
    @PostMapping
    public ResponseEntity create(@RequestBody EventEntity event,
                                 @RequestParam Long dayScheduleid){
        try {
            return ResponseEntity.ok(eventService.createEvent(event,dayScheduleid));
        }catch (StartTimeIncorrectException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка при создании задачи");
        }
    }

}
