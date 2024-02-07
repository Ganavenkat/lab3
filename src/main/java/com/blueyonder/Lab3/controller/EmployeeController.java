package com.blueyonder.Lab3.controller;

import com.blueyonder.Lab3.dao.EmployeeRepository;
import com.blueyonder.Lab3.dao.Mobilerepository;
import com.blueyonder.Lab3.dto.EmployeeDto;
import com.blueyonder.Lab3.dto.SuccessMessageDto;
import com.blueyonder.Lab3.exception.EmployeeAlreadyPresent;
import com.blueyonder.Lab3.exception.EmployeeEmailPresent;
import com.blueyonder.Lab3.exception.ResourceNotFound;
import com.blueyonder.Lab3.model.Employee;
import com.blueyonder.Lab3.model.Mobile;
import com.blueyonder.Lab3.service.EmployeeService;
import com.blueyonder.Lab3.util.EndUserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/EmpApi1toMany/v1.2CG")
@CrossOrigin
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Mobilerepository mobilerepository;


    // tested 07062021
    @PostMapping("/putemployees")
    public SuccessMessageDto createEmployee(@RequestBody EmployeeDto empDto)
            throws EmployeeAlreadyPresent, EmployeeEmailPresent {
        System.out.println("employee= " + empDto);
        /*
         * Employee e=new Employee(); e.setFirstName(empDto.getFirstName());
         * e.setLastName(empDto.getLastName());
         *
         * e.setEmailId(empDto.getEmailId());
         */
        // e.setMobileNumbers(empDto.getMobileNumbers());

//        List<Mobile> mobiles = empDto.getMobileNumbers();
//        List<Mobile> mob=new ArrayList<>();
//        for(var i:mobiles)
//        {
//            mob.add(mobilerepository.save(i));
//        }
//
//        Employee employee= new Employee(empDto);
//        employee.setMobileNumbers(mob);
//
//        employee = empService.save(employee);
//        return new SuccessMessageDto(EndUserMessage.employeeAddedSuccessFully + employee.getEmp_id());


        Employee employee=new Employee(empDto);
        employee = employeeRepository.save(employee);

        for(var s:empDto.getMobileNumbers())
        {
            Mobile mobile = new Mobile();
            mobile.setMob_number(s.getMob_number());
            mobile.setServiceProvider(s.getServiceProvider());
            mobile.setEmployee(employee);

            mobilerepository.save(mobile);
        }




        return new SuccessMessageDto(EndUserMessage.employeeAddedSuccessFully+employee.getEmp_id());

    }
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        List<Employee> el = employeeService.getAllEmployees();
        // el = empRepository.findAll();
        return el;
    }

    @DeleteMapping("/employees")
    public void deleteEmployeeById(@RequestParam Long id)
    {
        employeeService.deleteEmployeeById(id);
//        return new ResponseEntity<>("Deleted Employee "+id);
    }

//    @PutMapping("/employees")
//    public ResponseEntity<String> updateById(@RequestBody EmployeeDto employeeDto,@RequestParam Long id)
//    {
//        employeeService.updateById(employeeDto,id);
//        return new ResponseEntity<>("updated",HttpStatus.ACCEPTED);
//    }

    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployeeById(@RequestBody EmployeeDto emp)
        public ResponseEntity<Employee> updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDto emp)
            throws ResourceNotFound {
        System.out.println("controller updateEmployeeById");
        Employee updatedEmployee = employeeService.updateEmployeeById(id,emp);
        return new ResponseEntity<>(updatedEmployee,HttpStatus.ACCEPTED);

    }




}




