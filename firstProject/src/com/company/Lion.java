package com.company;

public class Lion extends Animal {
    private String name = "LionClass";
    public Lion( int age) {
        super(age, false);
    }

    @Override
    public String getName() {
        return name;
    }
}
