package com.example.springTaskManager.repository;

import com.example.springTaskManager.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalTime;
import java.util.List;

public interface EventRepo extends CrudRepository<EventEntity, Long> {
   List<EventEntity> findAllByStartTimeAndAndId(LocalTime time, Long id);
}
