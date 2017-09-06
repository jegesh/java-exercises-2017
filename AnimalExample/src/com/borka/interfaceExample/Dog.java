package com.borka.interfaceExample;

/**
 * Created by Comp14 on 05/09/2017.
 */
public class Dog extends Animal implements Moveable {
    public Dog(String name) {
        super(name);
    }


    public String geName() {
        return name;
    }

    @Override
    public String change() {
        return "changed" +name;
    }
}
