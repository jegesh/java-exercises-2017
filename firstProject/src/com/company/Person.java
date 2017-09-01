package com.company;

public class Person implements Living{

    private String name = "person";
    private int age;
    private boolean canFly;


    public Person(int age, boolean canFly) {
        this.age = age;
        this.canFly = canFly;
    }
    @Override
    public String getName() {
        return name;
    }

    public void flyalblility() {

        System.out.println(canFly ? true : false);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", canFly=" + canFly +
                '}';
    }
}
