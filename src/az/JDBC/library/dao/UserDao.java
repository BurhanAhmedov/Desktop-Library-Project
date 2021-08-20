package az.JDBC.library.dao;

import java.util.List;

import Model.User;

public interface UserDao {

    List<User> getUserList() throws Exception;

    void addUser(User user) throws Exception;

    User getUserById(Long userId) throws Exception;

    void deleteUser(Long userId) throws Exception;

    void editUser(User user) throws Exception;

    List<User> searchUser(String keyword) throws Exception;

}
