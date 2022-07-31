package com.example.Problem_2.dao;

import com.example.Problem_2.model.Gender;
import com.example.Problem_2.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")

public class FakeUserDataAccessService implements UserDao {
    private static List<User> DB = new ArrayList<>();
    @Override
    public int insertUser(UUID id, User user) {
        DB.add(new User(id,user.getName(),user.getDob(),user.getAddress(),user.getEmail(), (Gender) user.getGender()));
        return 1;
    }

    @Override
    public List<User> selectAllUser() {
        return DB;
    }

    @Override
    public Optional<User> selectUserById(UUID id) {
        return DB.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    @Override
    public int deleteUserById(UUID id) {
        Optional<User> userMaybe = selectUserById(id);
        if(userMaybe.isEmpty())
        {
            return 0;
        }
        else {
            DB.remove(userMaybe.get());
            return 1;
        }
    }

    @Override
    public int updateUserById(UUID id, User update) {
        return selectUserById(id).map(user1 -> {
            int indexOfUserToUpdate = DB.indexOf(user1);
            if (indexOfUserToUpdate >= 0)
            {
                DB.set(indexOfUserToUpdate, new User(id, update.getName(), update.getDob(), update.getAddress(),
                        update.getEmail(), (Gender) update.getGender()));
                return 1;
            }
            return 0;
        })
                .orElse(0);
    }
}
