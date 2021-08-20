/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.JDBC.library.dao.impl;

import Model.Author;
import Model.Book;
import Model.Employee;
import az.JDBC.library.dao.RentDao;
import Model.Rent;
import Model.User;
import az.JDBC.library.dao.DBHelper;
import az.JDBC.library.service.RentService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author burha
 */
public class RentDaoImpl implements RentDao {

    @Override
    public List<Rent> getRentList() throws Exception {
        List<Rent> rentList = new ArrayList<>();
        String sql = "SELECT \n"
                + "    r.id rent_id,\n"
                + "    b.id,\n"
                + "    b.name AS Book,\n"
                + "    a.Fullname AS Author,\n"
                + "    u.name as user_name, u.surname as user_surname ,\n"
                + "    r.payment as Payment,\n"
                + "    u.Telephone ,\n"
                + "    e.name as employee_name, e.surname as employee_surname,\n"
                + "r.Location,\n"
                + "    r.Take_time,\n"
                + "    r.Return_time\n"
                + "FROM\n"
                + "    book b\n"
                + "        INNER JOIN\n"
                + "    rent r ON b.id = r.Book_id\n"
                + "        INNER JOIN\n"
                + "    user u ON u.id = r.Reader_id\n"
                + "        INNER JOIN\n"
                + "    Author a ON a.id = r.author_id\n"
                + "        INNER JOIN\n"
                + "    Employee e ON e.id = r.Courier_id where r.active=1";
        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);) {
            if (connect != null) {
                while (rs.next()) {
                    Book book = new Book();
                    book.setName(rs.getString("Book"));
                    Author author = new Author();
                    author.setFullName(rs.getString("Author"));
                    User user = new User();
                    user.setName(rs.getString("user_name"));
                    user.setSurname(rs.getString("user_surname"));
                    user.setTelephone(rs.getString("Telephone"));
                    Employee employee = new Employee();
                    employee.setName(rs.getString("employee_name"));
                    employee.setSurname(rs.getString("employee_surname"));
                    Rent rent = new Rent();
                    rent.setId(rs.getLong("rent_id"));
                    rent.setPayment(rs.getFloat("Payment"));
                    rent.setLocation(rs.getString("Location"));
                    rent.setTakeTime(rs.getDate("Take_Time"));
                    rent.setReturnTime(rs.getDate("Return_Time"));
                    rent.setBook(book);
                    rent.setAuthor(author);
                    rent.setEmployee(employee);
                    rent.setUser(user);
                    rentList.add(rent);

                }
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rentList;

    }

    @Override
    public void addRent(Rent rent) throws Exception {
        String sql = "insert into rent(Book_id,Author_id,Reader_id,Payment,Courier_id,Take_time,Return_time,Location) "
                + "values (?,?,?,?,?,?,?,?)";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setLong(1, rent.getBook().getId());
            ps.setLong(2, rent.getAuthor().getId());
            ps.setLong(3, rent.getUser().getId());
            ps.setFloat(4, rent.getPayment());
            ps.setLong(5, rent.getEmployee().getId());
            ps.setDate(6, new java.sql.Date(rent.getTakeTime().getTime()));
            ps.setDate(7, new java.sql.Date(rent.getReturnTime().getTime()));
            ps.setString(8, rent.getLocation());
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public Rent getRentById(Long rentId) throws Exception {
        Rent rent = new Rent();
        String sql = "SELECT \n"
                + "    b.id,\n"
                + "    b.name AS Book,\n"
                + "    a.Fullname AS Author,\n"
                + "    u.name, u.surname ,\n"
                + "    r.payment as Payment,\n"
                + "    u.Telephone ,\n"
                + "    e.name, e.surname,\n"
                + "r.Location,\n"
                + "    r.Take_time,\n"
                + "    r.Return_time\n"
                + "FROM\n"
                + "    book b\n"
                + "        INNER JOIN\n"
                + "    rent r ON b.id = r.Book_id\n"
                + "        INNER JOIN\n"
                + "    user u ON u.id = r.Reader_id\n"
                + "        INNER JOIN\n"
                + "    Author a ON a.id = r.author_id\n"
                + "        INNER JOIN\n"
                + "    Employee e ON e.id = r.Courier_id where r.id=?";
        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, rentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Book book = new Book();
                book.setName(rs.getString("Book"));
                Author author = new Author();
                author.setFullName(rs.getString("Author"));
                User user = new User();
                user.setName(rs.getString("Name"));
                user.setSurname(rs.getString("Surname"));
                user.setTelephone(rs.getString("Telephone"));
                Employee employee = new Employee();
                employee.setName(rs.getString("Name"));
                employee.setSurname(rs.getString("Surname"));

                rent.setId(rs.getLong("id"));
                rent.setPayment(rs.getFloat("Payment"));
                rent.setLocation(rs.getString("Location"));
                rent.setTakeTime(rs.getDate("Take_Time"));
                rent.setReturnTime(rs.getDate("Return_Time"));
                rent.setBook(book);
                rent.setAuthor(author);
                rent.setEmployee(employee);
                rent.setUser(user);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return rent;

    }

    @Override
    public void editRent(Rent rent) throws Exception {
        String sql = "update rent set Book_id=?,Author_id=?,Reader_id=?,Payment=?,Courier_id=?,Take_time=?,Return_time=?,Location=? where id=?";
        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, rent.getBook().getId());
            ps.setLong(2, rent.getAuthor().getId());
            ps.setLong(3, rent.getUser().getId());
            ps.setFloat(4, rent.getPayment());
            ps.setLong(5, rent.getEmployee().getId());
            ps.setDate(6, new java.sql.Date(rent.getTakeTime().getTime()));
            ps.setDate(6, new java.sql.Date(rent.getReturnTime().getTime()));
            ps.setString(7, rent.getLocation());
            ps.setLong(8, rent.getId());
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteRent(Long rentId) throws Exception {
        String sql = "update rent set active=0 where rent.id=?";
        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, rentId);
            ps.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public List<Rent> searchRent(String keyword) throws Exception {
        List<Rent> rentList = new ArrayList<>();
        String sql = "SELECT \n"
                + "    b.id,\n"
                + "    b.name AS Book,\n"
                + "    a.Fullname AS Author,\n"
                + "    u.name, u.surname ,\n"
                + "    r.payment as Payment,\n"
                + "    u.Telephone ,\n"
                + "    e.name, e.surname,\n"
                + "r.Location,\n"
                + "    r.Take_time,\n"
                + "    r.Return_time\n from book b\n"
                + "        INNER JOIN\n"
                + "    rent r ON b.id = r.Book_id\n"
                + "        INNER JOIN\n"
                + "    user u ON u.id = r.Reader_id\n"
                + "        INNER JOIN\n"
                + "    Author a ON a.id = r.author_id\n"
                + "        INNER JOIN\n"
                + "    Employee e ON e.id = r.Courier_id where ( r.id like ? or b.name like ? or a.fullname like ? or u.name like ?"
                + "or u.surname like ? or u.telephone like ? or r.payment like ? or r.location like ? or e.name like ? or e.surname like ?) ";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, "%" + keyword + "%");
            ps.setString(2, "%" + keyword + "%");
            ps.setString(3, "%" + keyword + "%");
            ps.setString(4, "%" + keyword + "%");
            ps.setString(5, "%" + keyword + "%");
            ps.setString(6, "%" + keyword + "%");
            ps.setString(7, "%" + keyword + "%");
            ps.setString(8, "%" + keyword + "%");
            ps.setString(9, "%" + keyword + "%");
            ps.setString(10, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Rent rent = new Rent();
                Book book = new Book();
                book.setName(rs.getString("Book"));
                Author author = new Author();
                author.setFullName(rs.getString("Author"));
                User user = new User();
                user.setName(rs.getString("Name"));
                user.setSurname(rs.getString("Surname"));
                user.setTelephone(rs.getString("Telephone"));
                Employee employee = new Employee();
                employee.setName(rs.getString("Name"));
                employee.setSurname(rs.getString("Surname"));

                rent.setId(rs.getLong("id"));
                rent.setPayment(rs.getFloat("Payment"));
                rent.setLocation(rs.getString("Location"));
                rent.setTakeTime(rs.getDate("Take_Time"));
                rent.setReturnTime(rs.getDate("Return_Time"));
                rent.setBook(book);
                rent.setAuthor(author);
                rent.setEmployee(employee);
                rent.setUser(user);
                rentList.add(rent);

            }
        }
        return rentList;

    }
}
