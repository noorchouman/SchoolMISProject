package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class Department{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Staff> staffs;

    @OneToOne
    private Staff head;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public Staff getHead() {
        return head;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public void setHead(Staff head) {
        this.head = head;
    }
}

