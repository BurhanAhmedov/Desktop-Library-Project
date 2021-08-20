/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.service.impl;

import Model.Login;
import az.JDBC.library.dao.LoginDao;
import az.JDBC.library.service.LoginService;

/**
 *
 * @author burha
 */
public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public Login login(String username, String password) throws Exception {
        return loginDao.login(username, password);
    }

    @Override
    public void signUp(String name, String surname, String username, String password) throws Exception {
        loginDao.signUp(name, surname, username, password);
    }

}
