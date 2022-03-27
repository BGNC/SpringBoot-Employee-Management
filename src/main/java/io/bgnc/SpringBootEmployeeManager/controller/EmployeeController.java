package io.bgnc.SpringBootEmployeeManager.controller;

import io.bgnc.SpringBootEmployeeManager.model.Employee;
import io.bgnc.SpringBootEmployeeManager.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;



    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees(){
      List<Employee> employeeList=employeeService.getAllEmployees();

      return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long id){
        Employee employee=employeeService.findEmployeeById(id);

        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){

        Employee newEmployee = employeeService.addEmployee(employee);

        /**
         * CREATED MEANS : 201
         */
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);

    }

    @PutMapping("/updateEmployee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){

        /**
         * OK : 200
         * ACCEPTED:202
         */
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
