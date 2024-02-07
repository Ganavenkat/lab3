package com.blueyonder.Lab3.model;

import com.blueyonder.Lab3.dto.EmployeeDto;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Emp_id;
    private String firstName;
    private String lastName;
    @Column(name = "email_Id")
    private String emailId;

//    @Column(name = "email_Id",unique = true, nullable = false)
//    private String emailId;
    // @OneToMany(mappedBy="employee", fetch=FetchType.EAGER)//employee attribute of Mobile entity
//    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private List<Mobile> mobileNumbers	 = new ArrayList<Mobile>();

    @OneToMany(mappedBy = "employee",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Mobile> mobileNumbers;


    public List<Mobile> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setMobileNumbers(List<Mobile> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public Employee(EmployeeDto employeeDto) {
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.emailId = employeeDto.getEmailId();
    }

    public Employee() {
    }
    /*
     * public Employee(String firstName, String lastName, String emailId) { super();
     * this.firstName = firstName; this.lastName = lastName; this.emailId = emailId;
     * }
     */


    public Long getEmp_id() {
        return Emp_id;
    }


    public void setEmp_id(Long emp_id) {
        Emp_id = emp_id;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getEmailId() {
        return emailId;
    }


    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }



//    public List<Mobile> getMobileNumbers() {
//        return mobileNumbers;
//    }
//
//
//    public void setMobileNumbers(List<Mobile> mobileNumbers) {
//        this.mobileNumbers = mobileNumbers;
//    }


    @Override
    public String toString() {
        return "Employee [Emp_id=" + Emp_id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
                + emailId + ", ml=" + "]";
    }


}

