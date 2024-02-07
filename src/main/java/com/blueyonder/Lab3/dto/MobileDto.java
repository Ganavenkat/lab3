package com.blueyonder.Lab3.dto;

public class MobileDto {
    private Long Mob_id;
    private Long mob_number;
    private String serviceProvider;
    private EmployeeDto employee;


    public MobileDto() {
    }


    public MobileDto(Long mob_number, String serviceProvider, EmployeeDto employee) {
        super();
        this.mob_number = mob_number;
        this.serviceProvider = serviceProvider;
        this.employee = employee;
    }


    public MobileDto(Long mob_id, Long mob_number, String serviceProvider, EmployeeDto employee) {
        super();
        Mob_id = mob_id;
        this.mob_number = mob_number;
        this.serviceProvider = serviceProvider;
        this.employee = employee;
    }


    public Long getMob_id() {
        return Mob_id;
    }


    public void setMob_id(Long mob_id) {
        Mob_id = mob_id;
    }


    public Long getMob_number() {
        return mob_number;
    }


    public void setMob_number(Long mob_number) {
        this.mob_number = mob_number;
    }


    public EmployeeDto getEmployee() {
        return employee;
    }


    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }


    public String getServiceProvider() {
        return serviceProvider;
    }


    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }


    /*
     * @Override public String toString() { return "Mobile [Mob_id=" + Mob_id +
     * ", mob_number=" + mob_number + ", serviceProvider=" + serviceProvider +
     * ", employee=" + employee + "]"; }
     */


    /*
     * public Mobile(long mob_id, int mob_number) { super(); Mob_id = mob_id;
     * this.mob_number = mob_number; }
     */


}
