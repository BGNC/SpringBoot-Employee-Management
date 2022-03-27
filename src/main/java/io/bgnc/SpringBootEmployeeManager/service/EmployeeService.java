package io.bgnc.SpringBootEmployeeManager.service;

import io.bgnc.SpringBootEmployeeManager.exceptions.EmployeeNotFoundException;
import io.bgnc.SpringBootEmployeeManager.model.Employee;
import io.bgnc.SpringBootEmployeeManager.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;



    public Employee addEmployee(Employee employee){

        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);


    }

    public void deleteEmployee(Long employeeId){
        employeeRepository.deleteEmployeeById(employeeId);

    }
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee findEmployeeById(Long id){
        return employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + id + " could not found"));

    }



    public Employee updateEmployee(Employee employee){
         return employeeRepository.save(employee);

    }


}
