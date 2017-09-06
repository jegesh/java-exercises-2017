package com.borka.interfaceExample;

/**
 * Created by Comp14 on 05/09/2017.
 */
public class Person implements Moveable{
    String name;

    public Person(String name) {
        this.name = name;
    }



    public String getName() {
      return name;
    }

    @Override
    public String change() {
        return "changed" +name;
    }
}

