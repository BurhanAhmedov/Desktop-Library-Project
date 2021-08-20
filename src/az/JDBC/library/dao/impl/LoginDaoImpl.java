/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.dao.impl;

import Model.Login;
import az.JDBC.library.dao.DBHelper;
import az.JDBC.library.dao.LoginDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author burha
 */
public class LoginDaoImpl implements LoginDao {

    @Override
    public Login login(String username, String password) throws Exception {
        Login login = new Login();
        String sql = "Select id,Username,Name,Surname from login where active=1 and Username=? and Password=?";
        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                login.setName(rs.getString("Name"));
                login.setSurname(rs.getString("Surname"));
                login.setUsername(rs.getString("username"));
            } else {
                login = null;
            }

        }

        return login;

    }

    @Override
    public void signUp(String name, String surname, String username, String password) throws Exception {

        String sql = "insert into library.login(Name,Surname,Username,Password) values (?,?,?,?)";
        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, name);
            ps.setString(2, surname);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
