/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.dao;

import Model.Login;

/**
 *
 * @author burha
 */
public interface LoginDao {

    Login login(String username, String password) throws Exception;

    void signUp(String name, String surname, String username, String password) throws Exception;

}
