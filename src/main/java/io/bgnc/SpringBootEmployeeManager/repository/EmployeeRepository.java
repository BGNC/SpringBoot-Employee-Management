package io.bgnc.SpringBootEmployeeManager.repository;

import io.bgnc.SpringBootEmployeeManager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long employeeId);

    Optional<Employee> findEmployeeById(Long id);
}
