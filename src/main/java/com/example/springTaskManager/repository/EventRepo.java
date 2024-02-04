package com.example.springTaskManager.repository;

import com.example.springTaskManager.entity.EventEntity;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<EventEntity, Long> {

}
