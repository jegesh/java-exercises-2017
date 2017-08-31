package com.company;

public class Animal {

    private String name = "animalClass";
    private int age;
    private boolean canFly;


    public Animal(int age, boolean canFly) {
        this.age = age;
        this.canFly = canFly;
    }

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
