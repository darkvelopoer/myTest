package com.yyh.practice;

import java.util.Objects;

public class PersonObj {
    private String name;
    private Integer age;

    public PersonObj(String name, Integer age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "PersonObj{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonObj personObj = (PersonObj) o;
        return name.equals(personObj.name) &&
                age.equals(personObj.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
