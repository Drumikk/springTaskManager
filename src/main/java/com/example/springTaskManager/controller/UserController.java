package com.example.springTaskManager.controller;

import com.example.springTaskManager.entity.UserEntity;
import com.example.springTaskManager.exception.UserAlreadyExistException;
import com.example.springTaskManager.exception.UserNotFoundException;
import com.example.springTaskManager.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//Контроллер пользователя
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    //Вся логика описана в сервисе, в контроллере только обработка запросов
    @Autowired
    private UserService userService;


    //POST запрос, требуется тело JSON при запросе
    @PostMapping("/create_user")
    public ResponseEntity registration(@Valid @RequestBody UserEntity user){
        try{
            //тянем функции из сервиса и выполняем "регистрацию" (добавление в БД юзеров)
            userService.registration(user);
            return ResponseEntity.ok("Пользователь успешно сохранён");
        } catch(UserAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка при сохранении пользователя");
        }
    }

    //GET запрос, требуется id в строке формата "?id=3" при запросе
    @GetMapping
    public ResponseEntity getOneUser(@RequestParam Long id) {
        try{
            return ResponseEntity.ok(userService.getOne(id));
        } catch(UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка при получении пользователя");
        }
    }
    //Delete запрос, принимает часть строки запроса
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok(userService.delete(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка при удалении пользователя");
        }
    }
    @PutMapping("/update")
    public ResponseEntity updateUser(@RequestBody UserEntity user,
                                     @RequestParam Long userid){
        try{
            return ResponseEntity.ok(userService.update(user, userid));
        }catch(UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Произошла ошибка при обновлении пользователя");
        }
    }
}
