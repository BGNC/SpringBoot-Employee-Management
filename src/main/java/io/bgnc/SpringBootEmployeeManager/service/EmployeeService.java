package io.bgnc.SpringBootEmployeeManager.service;

import io.bgnc.SpringBootEmployeeManager.exceptions.EmployeeNotFoundException;
import io.bgnc.SpringBootEmployeeManager.model.Employee;
import io.bgnc.SpringBootEmployeeManager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

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

    public Optional<Employee> findEmployeeById(Long id){
        return Optional.ofNullable(employeeRepository.findEmployeeById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee by id " + id + " could not found")));

    }



    public Employee updateEmployee(Employee employee){
         return employeeRepository.save(employee);

    }


}
