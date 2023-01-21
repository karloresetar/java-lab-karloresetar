package com.kayo.lab6.repositories;

import com.kayo.lab6.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class UserRepository {
    private List<User> users;
    public UserRepository() {
        users=new ArrayList<>();
    }

    public List<User> getAll(){
        return users;
    }

    public User getById(Long id) {
        User user = new User();
        for (User u:users) {
            if(Objects.equals(u.getDeviceId(), id)) {
                return u;
            }
        }
        return user;
    }

    public void add(User user) {
        users.add(user);
    }

    public void deleteById(Long id) {
        users.removeIf(u -> Objects.equals(u.getUserId(), id));
    }
}
