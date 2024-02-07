package com.blueyonder.Lab3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long Mob_id;
//    @Column(name = "mob_number", unique = false, nullable = false)
    private Long mob_number;
    private String serviceProvider;
//    @ManyToOne
//    @JsonIgnore // required in case of bidirectional,to avoid chain of interractions
//    private Employee employee;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "emp_id")
    private Employee employee;

    public Mobile() {
        // TODO Auto-generated constructor stub
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


    public Employee getEmployee() {
        return employee;
    }


    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public String getServiceProvider() {
        return serviceProvider;
    }


    public void setServiceProvider(String serviceProvider) {
        this.serviceProvider = serviceProvider;
    }


    @Override
    public String toString() {
        return "Mobile [Mob_id=" + Mob_id + ", mob_number=" + mob_number + ", serviceProvider=" + serviceProvider + "]";
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


