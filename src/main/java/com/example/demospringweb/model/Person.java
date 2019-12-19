package com.example.demospringweb.model;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private Integer age;
    private String telephone;
    private String email;
    private int salary;

    @Enumerated
    private PersonType personType;

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public Person(String name, Integer age, String telephone, String email) {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.personType=PersonType.KAN;
    }

    public Person(String name, Integer age, String telephone, String email, int salary) {
        this.name = name;
        this.age = age;
        this.telephone = telephone;
        this.email = email;
        this.salary=salary;
        this.personType=PersonType.EMP;
    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
