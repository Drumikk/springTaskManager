package com.example.springTaskManager.repository;

import com.example.springTaskManager.entity.DayScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DayScheduleRepo extends CrudRepository<DayScheduleEntity, Long> {
}
