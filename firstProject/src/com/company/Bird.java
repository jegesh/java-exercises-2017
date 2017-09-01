package com.company;

public class Bird extends Animal {
    private String name = "birdClass";

    public Bird(int age) {
        super(age, true);
    }

    @Override
    public String getName() {
        return name;
    }
}
