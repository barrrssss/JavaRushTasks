package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> userList = userService.getUsersBetweenLevels(1, 100);
        modelData.setUsers(userList);
    }

    @Override
    public void loadDeletedUsers(){
        List<User> userList = userService.getAllDeletedUsers();
        modelData.setUsers(userList);
    }
}
