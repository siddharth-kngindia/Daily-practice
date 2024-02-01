package com.springbootcloud.service;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.springbootcloud.exception.EmployeeNotFoundException;
import com.springbootcloud.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employees = new ArrayList<>();
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId()==null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        return employees
                .stream()
                .filter(employee -> employee.getEmployeeId()
                        .equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException(("Employee not found with id" + id)));
//                .get();
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee =employees
                .stream()
                .filter(e ->e.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();

        employees.remove(employee);
        return "Employee deleted with id" + id;
    }


}
