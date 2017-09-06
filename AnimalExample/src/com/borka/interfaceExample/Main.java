package com.borka.interfaceExample;

import com.borka.interfaceExample.Cat;
import com.borka.interfaceExample.Dog;
import com.borka.interfaceExample.Moveable;
import com.borka.interfaceExample.Person;

public class Main {

    public static void main(String[] args) {

        Cat cat = new Cat("Cat") ;
      Dog dog = new Dog ("Dog");
      Person person = new Person("Boris");
         getName(cat);
        getName(person);

        change(cat);
        change(person);
//        System.out.println(person.getCreatureName());
//        System.out.println(dog.getCreatureName());
    }

    public static void getName(Moveable moveable)
    {
        System.out.println(moveable.getName());
    }

    public static void change (Moveable moveable)
    {
        System.out.println(moveable.change());
    }


}

