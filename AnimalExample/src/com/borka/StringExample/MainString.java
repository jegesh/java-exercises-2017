package com.borka.StringExample;

/**
 * Created by Comp14 on 06/09/2017.
 */
public class MainString {
    public static void main(String[] args) {
        char [] chars = {'h','e','l','l','o',' ','w','o','r','l','d'};
        MyString myString = new MyString(chars);

         myString.print();
        System.out.println(myString.indexOf('e'));
       System.out.println(myString.charAt(4));
        System.out.println(myString.howManyChars('o'));
       System.out.println(myString.contains('k'));

       String firstWord = myString.subString (0,5);
        System.out.println(firstWord);
    //Advanced

        char [] c = {'w','o','r','l','d'};
       System.out.println(myString.endWith(c));
        System.out.println(myString.equals(c));
       String newWord=(myString.replace('k',4));
        System.out.println(newWord);
    }

}
