package com.example.Problem_2.dao;

import com.example.Problem_2.model.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserDao {
    int insertUser(UUID id, User user);
    default int insertUser(User user){
        UUID id = UUID.randomUUID();
        return insertUser(id,user);
    }
    List<User> selectAllUser();
    Optional<User> selectUserById(UUID id);

    int deleteUserById(UUID id);

    int updateUserById(UUID id, User user);

    
}
