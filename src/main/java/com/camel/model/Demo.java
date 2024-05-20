package com.camel.model;

import javax.persistence.*;

@Entity
public class Demo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
    private Integer id;

    private String name;

    private String dept;

    public Demo() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Demo(String name, String dept) {
        super();
        this.name = name;
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }


}
