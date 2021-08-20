package az.JDBC.library.service;

import java.util.List;

import Model.User;

public interface UserService {

    List<User> getUserList() throws Exception;

    void addUser(User user) throws Exception;

    User getUserById(Long userId) throws Exception;

    void deleteUser(Long userId) throws Exception;

    void editUser(User user) throws Exception;

    List<User> searchUser(String keyword) throws Exception;

}
