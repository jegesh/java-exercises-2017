package com.borka.interfaceExample;

/**
 * Created by Comp14 on 05/09/2017.
 */
public class Cat extends Animal implements Moveable {

    public Cat(String name) {
        super(name);
    }

    @Override
    public String getName() {
            return name;
    }


    @Override
    public String change() {
        return "changed" +name;
    }
}
