package az.JDBC.library.service.impl;

import Model.User;
import az.JDBC.library.dao.UserDao;
import az.JDBC.library.service.UserService;
import java.util.List;



public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUserList() throws Exception {

        return userDao.getUserList();
    }

    @Override
    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }

    @Override
    public User getUserById(Long userId) throws Exception {

        return userDao.getUserById(userId);
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        userDao.deleteUser(userId);
    }

    @Override
    public void editUser(User user) throws Exception {
        userDao.editUser(user);
    }

    @Override
    public List<User> searchUser(String keyword) throws Exception {
        return userDao.searchUser(keyword);
    }

}
