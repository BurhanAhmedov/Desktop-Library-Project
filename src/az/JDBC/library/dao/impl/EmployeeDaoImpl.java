package az.JDBC.library.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Employee;
import az.JDBC.library.dao.*;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "Select id,name,surname,position,telephone,e_mail,identity_No,gender,birthday,salary,recruitment,dismissal from employee where active=1";
        try (Connection connect = DBHelper.getConnection();
                PreparedStatement ps = connect.prepareStatement(sql);
                ResultSet rs = ps.executeQuery(sql);) {

            if (connect != null) {
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setId(rs.getLong("id"));
                    employee.setName(rs.getString("name"));
                    employee.setSurname(rs.getString("surname"));
                    employee.setPosition(rs.getString("position"));
                    employee.setTelephone(rs.getString("telephone"));
                    employee.setE_mail(rs.getString("e_mail"));
                    employee.setIdendity_No(rs.getString("identity_No"));
                    employee.setSalary(rs.getInt("salary"));
                    employee.setRecruitment(rs.getDate("recruitment"));
                    employee.setDismissal(rs.getDate("dismissal"));
                    employee.setBirthday(rs.getDate("birthday"));
                    employee.setGender(rs.getString("gender"));

                    employeeList.add(employee);
                }
            } else {
                System.out.println("Connection is null");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        String sql = "insert into employee(name,surname,position,telephone,e_mail,identity_No,salary,recruitment,gender,birthday)values(?,?,?,?,?,?,?,?,?,?)";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getPosition());
            ps.setString(4, employee.getTelephone());
            ps.setString(5, employee.getE_mail());
            ps.setString(6, employee.getIdendity_No());
            ps.setInt(7, employee.getSalary());
            ps.setDate(8, new java.sql.Date(employee.getRecruitment().getTime()));
            ps.setString(9, employee.getGender());
            ps.setDate(10, new java.sql.Date(employee.getBirthday().getTime()));
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws Exception {
        Employee employee = new Employee();
        String sql = "Select id,name,surname,position,telephone,e_mail,identity_No,gender,birthday,salary,recruitment,dismissal from employee where id=? and  active=1";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setLong(1, employeeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                employee.setId(rs.getLong("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setPosition(rs.getString("position"));
                employee.setTelephone(rs.getString("telephone"));
                employee.setE_mail(rs.getString("e_mail"));
                employee.setIdendity_No(rs.getString("identity_No"));
                employee.setSalary(rs.getInt("salary"));
                employee.setRecruitment(rs.getDate("recruitment"));
                employee.setDismissal(rs.getDate("dismissal"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setGender(rs.getString("gender"));

            } else {
                employee = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void editEmployee(Employee employee) throws Exception {
        String sql = "update employee set name=?,surname=?,position=?,telephone=?,e_mail=?,identity_No=?,gender=?,birthday=?,salary=?,recruitment=?,dismissal=? from employee where id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getPosition());
            ps.setString(4, employee.getTelephone());
            ps.setString(5, employee.getE_mail());
            ps.setString(6, employee.getIdendity_No());
            ps.setString(7, employee.getGender());
            ps.setDate(8, new java.sql.Date(employee.getBirthday().getTime()));
            ps.setInt(9, employee.getSalary());
            ps.setDate(10, new java.sql.Date(employee.getRecruitment().getTime()));
            ps.setDate(11, new java.sql.Date(employee.getDismissal().getTime()));
            ps.setLong(12, employee.getId());
            ps.execute();
        }
    }

    @Override
    public void deleteEmployee(Long employeeId) throws Exception {
        String sql = "update  employee set active=0 where id=?";
        try (Connection connect = DBHelper.getConnection(); PreparedStatement ps = connect.prepareStatement(sql);) {
            ps.setLong(1, employeeId);
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Employee> searchEmployee(String keyword) throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "Select * from Employee where (id like ? or name like ? or surname like ? or position like ? or telephone like ? or e_mail like ? or identity_No like ? or gender like ? or birthday like ? or salary like ? or recruitment like ? or dismissal like ?) and active=1";
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
            ps.setString(11, "%" + keyword + "%");
            ps.setString(12, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employee employee = new Employee();
                employee.setId(rs.getLong("id"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setPosition(rs.getString("position"));
                employee.setTelephone(rs.getString("telephone"));
                employee.setE_mail(rs.getString("e_mail"));
                employee.setIdendity_No(rs.getString("identity_No"));
                employee.setSalary(rs.getInt("salary"));
                employee.setRecruitment(rs.getDate("recruitment"));
                employee.setDismissal(rs.getDate("dismissal"));
                employee.setBirthday(rs.getDate("birthday"));
                employee.setGender(rs.getString("gender"));
                employeeList.add(employee);

            }

        }
        return employeeList;

    }
}
