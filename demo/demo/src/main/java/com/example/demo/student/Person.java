package com.example.demo.student;

public class Person {
    private String name;
    private int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getter și Setter pentru name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter și Setter pentru age
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
