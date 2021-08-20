package az.JDBC.library.service.impl;

import java.util.List;

import Model.Employee;
import az.JDBC.library.dao.EmployeeDao;
import az.JDBC.library.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> getEmployeeList() throws Exception {
        return employeeDao.getEmployeeList();
    }

    @Override
    public void addEmployee(Employee employee) throws Exception {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(Long employeeId) throws Exception {
        return employeeDao.getEmployeeById(employeeId);
    }

    @Override
    public void editEmployee(Employee employee) throws Exception {
        employeeDao.editEmployee(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) throws Exception {
        employeeDao.deleteEmployee(employeeId);
    }

    @Override
    public List<Employee> searchEmployee(String keyword) throws Exception {
        return employeeDao.searchEmployee(keyword);

    }

}
