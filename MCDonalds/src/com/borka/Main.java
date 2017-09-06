package com.borka;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        User a =new User("AAA","111");
        User b =new User("BBB","222");
        User c =new User("CCC","333");

     //   User [] users = new User(a,b,c);
        User [] users = null;
        users [0] = a;

        System.out.println(users.toString());
       // HashMap hashMap = new HashMap();


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter user");
        String u =sc.nextLine();
        System.out.println("Enter password");
        String p =sc.nextLine();

    //   login (u,p);

    }

//        public static User login(String u, String p)
//        {
//
//        }

}
