package com.oopstart;

public class Person {
    private final String name;
    private final int age;
    private final String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void introduceYourself() {
        System.out.println("Hi, my name is " + name + "i am " + age +"years old and my gender is " + gender);
    }
}
