package az.JDBC.library.dao.impl;

import Model.Genre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.User;
import az.JDBC.library.dao.DBHelper;
import az.JDBC.library.dao.UserDao;

public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getUserList() throws Exception {
        List<User> userList = new ArrayList<>();
        String sql = "Select * from user where active=1";
        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);) {

            if (connect != null) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("Name"));
                    user.setSurname(rs.getString("Surname"));
                    user.setGender(rs.getString("gender"));
                    user.setIdentity_No(rs.getString("identity_No"));
                    user.setTelephone(rs.getString("telephone"));
                    user.setE_mail(rs.getString("e_mail"));
                    userList.add(user);

                }
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public void addUser(User user) throws Exception {
        String sql = "insert into user(name,surname,gender,identity_No,telephone,e_mail) values (?,?,?,?,?,?)";

        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getIdentity_No());
            ps.setString(5, user.getTelephone());
            ps.setString(6, user.getE_mail());
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User getUserById(Long userId) throws Exception {
        User user = new User();
        String sql = "Select * From User where id=? and active=1";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setGender(rs.getString("gender"));
                user.setIdentity_No(rs.getString("identity_No"));
                user.setTelephone(rs.getString("Telephone"));
                user.setE_mail(rs.getString("E_mail"));

            } else {
                user = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void deleteUser(Long userId) throws Exception {
        String sql = "Update User set active=0 where id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, userId);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editUser(User user) throws Exception {
        String sql = "Update User set name=?,surname=?,gender=?,identity_No=?,telephone=?,E_mail=? where id=? and active=1";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getIdentity_No());
            ps.setString(5, user.getTelephone());
            ps.setString(6, user.getE_mail());
            ps.setLong(7, user.getId());
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> searchUser(String keyword) throws Exception {
        List<User> userList = new ArrayList<>();
        String sql = "Select * from User where (id like ? or name like ? or surname like ? or gender like ? or identity_No like ? or telephone like ? or E_mail like ?) and active=1";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            ps.setString(5, "%" + keyword + "%");
            ps.setString(6, "%" + keyword + "%");
            ps.setString(7, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));
                user.setGender(rs.getString("gender"));
                user.setIdentity_No(rs.getString("identity_No"));
                user.setTelephone(rs.getString("Telephone"));
                user.setE_mail(rs.getString("E_mail"));
                userList.add(user);
            }
        }
        return userList;
    }
}
