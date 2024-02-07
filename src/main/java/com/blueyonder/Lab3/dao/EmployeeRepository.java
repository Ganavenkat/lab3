package com.blueyonder.Lab3.dao;

import com.blueyonder.Lab3.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public List<Employee> findByEmailId(String emailId);
}
