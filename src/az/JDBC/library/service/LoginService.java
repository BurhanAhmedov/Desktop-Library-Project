/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.service;

import Model.Login;

/**
 *
 * @author burha
 */
public interface LoginService {

    Login login(String username, String password) throws Exception;

    void signUp(String name, String surname, String username, String password) throws Exception;

}
