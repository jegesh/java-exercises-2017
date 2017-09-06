package com.borka.StringExample;

/**
 * Created by Comp14 on 06/09/2017.
 */
public class MyString {

    char[] chars;

    public MyString(char[] chars) {
        this.chars = chars;
    }

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    //////////////// print ///////////////
    public void print() {

        for (char curr:  chars ) {
            System.out.print(curr);
        }
        System.out.println("");
    }

    ///////////////////// indexOf ///////////////////
    public int indexOf(char inputChar) {

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == inputChar)
                return i;


        }
        return -1;
    }

    ////////////// charAt //////////////
    public Character charAt(int index) {

        if (index >=0 && index < chars.length) {
             return chars[index];
                         }
        return 0;
    }

    public int howManyChars(char inputChar) {
        int count = 0;

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == inputChar)
                count++;
        }
        return count;
    }

    public boolean contains(char inputChar) {
       //return howManyChars(inputChar) > 0 ? true : false;
        return
    }

    public  String subString (int start , int end)
    {
        String str="";
        for (int i = start; i < end; i++) {

           str =str+ chars[i];
        }

        return str;
    }

   public boolean endWith ( char [] end)
   {
       int count = chars.length- end.length;

       for (int i = count; i < end.length; i++) {
           for (int j = 0; j < chars.length; j++) {
               if (end [i] != chars [j])
                  return false;
           }
//               return true;
       }
       return true;
   }


       public boolean equal ( char [] end)
   {
       if (chars.length==end.length)
       {
       for (int i = 0; i < chars.length; i++) {

           for (int j = 0; j < end.length; j++) {

               if (chars[i] != end[i])
                return false;

           }
          return true;
       }

       return true;
   }
      return false;
   }

   public String  replace(char a, int index)
   {
       String temp="";
       for (int i = 0; i < chars.length; i++) {

           if (i == index)
               chars[i] ='k';
           temp = temp+ chars[i];
       }
       return temp ;
   }
}
