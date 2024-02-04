package com.example.springTaskManager.repository;

import com.example.springTaskManager.entity.UserEntity;
import com.example.springTaskManager.model.User;
import org.springframework.data.repository.CrudRepository;
//Интерфейс для взаимодействия с БД, указываем с какой сущностью и тип ID
public interface UserRepo extends CrudRepository<UserEntity,Long> {
    //Метод для нахождения пользователь по email (необходим для проверки уникальных пользователей)
    UserEntity findByEmail(String email);
//    UserEntity updateUser(UserEntity user);
//    Long deleteByEmail(String email);
}
