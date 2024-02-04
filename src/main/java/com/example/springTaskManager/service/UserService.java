package com.example.springTaskManager.service;

import com.example.springTaskManager.entity.UserEntity;
import com.example.springTaskManager.exception.UserAlreadyExistException;
import com.example.springTaskManager.exception.UserNotFoundException;
import com.example.springTaskManager.model.User;
import com.example.springTaskManager.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //интерфейс для работы с БД
    @Autowired
    private UserRepo userRepo;
//    Добавление одного юзера в БД
    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByEmail(user.getEmail()) !=null)
        {
            throw new UserAlreadyExistException("Пользователь с таким EMAIL уже существует!");
        }
        return userRepo.save(user);
    }
//Получаем одного юзера
    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user.getId() == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        return User.toModel(user);
    }
    //Удаляем по айди, можно в репозитории сделать функцию для удаления по любой строке

    public Long delete(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user.getId() == null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        userRepo.deleteById(id);
        return id;
    }
    public User update(UserEntity user, Long userid) throws UserNotFoundException {
            UserEntity userEntity = userRepo.findById(userid).get();
        if (userEntity.getId()==null){
            throw new UserNotFoundException("Пользователь не найден");
        }
        userEntity.setEmail(user.getEmail());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());
        return User.toModel(userRepo.save(userEntity));
    }
}
