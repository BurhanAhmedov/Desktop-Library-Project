package az.JDBC.library.service;

import java.util.List;

import Model.Employee;
import az.JDBC.library.dao.EmployeeDao;

public interface EmployeeService {

    List<Employee> getEmployeeList() throws Exception;

    void addEmployee(Employee employee) throws Exception;

    Employee getEmployeeById(Long employeeId) throws Exception;

    void editEmployee(Employee employee) throws Exception;

    void deleteEmployee(Long employeeId) throws Exception;

    List<Employee> searchEmployee(String keyword) throws Exception;

}
