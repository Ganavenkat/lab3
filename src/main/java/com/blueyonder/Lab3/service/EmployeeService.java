package com.blueyonder.Lab3.service;

import com.blueyonder.Lab3.dao.EmployeeRepository;
import com.blueyonder.Lab3.dto.EmployeeDto;
import com.blueyonder.Lab3.exception.EmployeeAlreadyPresent;
import com.blueyonder.Lab3.exception.EmployeeEmailPresent;
import com.blueyonder.Lab3.exception.ResourceNotFound;
import com.blueyonder.Lab3.model.Employee;
import com.blueyonder.Lab3.model.Mobile;
import com.blueyonder.Lab3.util.EndUserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository empRepository;
//    @Autowired
//    private MobileRepository mobRepository;


    // tested 07062021(backend)
    public Employee save(Employee employee) throws EmployeeAlreadyPresent, EmployeeEmailPresent {
        System.out.println("service-save()" + employee);
        Optional<Employee> optEmp = empRepository.findById(employee.getEmp_id());


        if (optEmp.isPresent()) {
            throw new EmployeeAlreadyPresent(EndUserMessage.employeeAllreadyExists);
        }


        List<Employee> el = empRepository.findByEmailId(employee.getEmailId());
        System.out.println("No error upto here");
        if (el.size() > 0) {
            System.out.println("email duplicates");
            throw new EmployeeEmailPresent(EndUserMessage.emailAllreadyExists);
        }


        Employee emp = new Employee();


        emp.setEmp_id(employee.getEmp_id());
        emp.setFirstName(employee.getFirstName());
        emp.setLastName(employee.getLastName());
        emp.setEmailId(employee.getEmailId());
//        emp.setMobileNumbers(employee.getMobileNumbers());
        // emp.setMobileNumbers
        // emp.setMobileNumbers();
        System.out.println("Inside service 1");

//
//        for (Mobile mobile : employee.getMobileNumbers()) {
//            System.out.println("inside for loop");
//            mobile.setEmployee(emp);
//        }


        return empRepository.save(emp);
        // return employee;
    }


    public List<Employee> getAllEmployees() {
        List<Employee> el = new ArrayList<>();
        el = empRepository.findAll();
        return el;
    }

    public void deleteEmployeeById(Long id)
    {
//        Optional<Employee> employee = empRepository.findById(id);

        empRepository.deleteById(id);
    }

//    public Employee updateById(EmployeeDto employeeDto,Long id)
//    {
//        Employee employee = empRepository.findById(id).get();
//        employee.setEmailId(employeeDto.getEmailId());
//        employee.setFirstName(employeeDto.getFirstName());
//        employee.setLastName(employeeDto.getLastName());
//        employee.setMobileNumbers(employeeDto.getMobileNumbers());
//        List<Mobile> mobiles = new ArrayList<>();
//
//        for(var s:employeeDto.getMobileNumbers())
//        {
//            Mobile mobile = new Mobile();
//            mobile.setServiceProvider(s.getServiceProvider());
//            mobile.setMob_number(s.getMob_number());
//            mobile.setEmployee(s.getEmployee());
//
//            mobiles.add(mobile);
//        }
//        employee.setMobileNumbers(mobiles);
//        employee = empRepository.save(employee);
//
//
//        return employee;
//    }

//    public ResponseEntity<Employee> updateEmployeeById(EmployeeDto emp) throws ResourceNotFound {
    public Employee updateEmployeeById(Long id, EmployeeDto emp) throws ResourceNotFound {
        System.out.println("0.Service-updateEmployeeById");
        System.out.println("1.emp.getFirstName() service" + emp.getFirstName());
        System.out.println("1.emp.getEmp_id() service" + emp.getEmp_id());
        Employee empN = empRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound(EndUserMessage.employeeNotFound + emp.getEmp_id()));
        System.out.println("1a.emp.getFirstName() service" + emp.getFirstName());
        empN.setFirstName(emp.getFirstName());
        empN.setLastName(emp.getLastName());
        empN.setEmailId(emp.getEmailId());


        for (Mobile mobile:emp.getMobileNumbers()) {
            System.out.println("inside for loop");
            if(mobile.getMob_number()!=null)mobile.setMob_number(mobile.getMob_number());
            if(mobile.getServiceProvider()!=null)mobile.setServiceProvider(mobile.getServiceProvider());


            mobile.setEmployee(empN);
//            m.setEmployee(empN);

        }

        empN.setMobileNumbers(emp.getMobileNumbers());

        Employee updatedEmployee = empRepository.save(empN);
        System.out.println("2.emp service" + emp);
        return updatedEmployee;
    }

}




