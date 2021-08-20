package az.JDBC.library.dao;

import java.util.List;

import Model.Employee;

public interface EmployeeDao {

    List<Employee> getEmployeeList() throws Exception;

    void addEmployee(Employee employee) throws Exception;

    Employee getEmployeeById(Long employeeId) throws Exception;

    void editEmployee(Employee employee) throws Exception;

    void deleteEmployee(Long employeeId) throws Exception;

    List<Employee> searchEmployee(String keyword) throws Exception;

}
