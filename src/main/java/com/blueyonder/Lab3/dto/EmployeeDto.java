package com.blueyonder.Lab3.dto;

import com.blueyonder.Lab3.model.Mobile;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDto {
    private Long emp_id;
    private String firstName;
    private String lastName;
    private String emailId;
    private List<Mobile> mobileNumbers = new ArrayList<>();


    public EmployeeDto() {
    }


    public EmployeeDto(String firstName, String lastName, String emailId) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }


    public EmployeeDto(Long emp_id, String firstName, String lastName, String emailId) {
        super();
        this.emp_id = emp_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }


    public Long getEmp_id() {
        return emp_id;
    }


    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
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


    public List<Mobile> getMobileNumbers() {
        return mobileNumbers;
    }


    public void setMobileNumbers(List<Mobile> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }


}
