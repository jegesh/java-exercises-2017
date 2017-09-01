package com.company;

public class Main {

    public static void main(String[] args) {
//        int[] arr = {-5, 4, 185, 8};
//        int bigNum = arr[0];
//        int smallNum = arr[0];
//
//        for (int i = 1; i < arr.length; i++) {
//            if (arr[i] > bigNum)
//                bigNum = arr[i];
//            if (arr[i] < smallNum)
//                smallNum = arr[i];
//        }
//        System.out.println("big:" + bigNum + " ,small:" + smallNum);
        Animal animal = new Animal(1, true);
        Bird bird = new Bird(2);
        Lion lion = new Lion(3);
        Person person = new Person(4, false);
        getObjectName(animal);
        getObjectName(bird);
        getObjectName(lion);
        getObjectName(person);

    }


     public static void getObjectName(Living living) {
         System.out.println(living.getName());
    }
}