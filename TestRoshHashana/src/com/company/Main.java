package com.company;

///// STRINGS and equals tests
public class Main {

    public static void main(String[] args) {

	    String a = "aaa";
        String b = "bbb";
        String c = "ccc";
        String aa = " aaa ";
        String bb = " bbb ";
        String cc = " ccc ";
        String d = "ccc";
        String f = "";
        String e = new String("ccc");
        String r,t1,t2;

        r = a.concat(b.concat(c));

        t1 = aa.trim()+bb+cc.trim();
        t2 = aa.trim()+bb.trim()+cc.trim();

        System.out.println("concat =: "+r);
        System.out.println();
        System.out.println("trim 1 =: "+t1);
        System.out.println();
        System.out.println("trim 2 =: "+t2);
        System.out.println();
        System.out.println("c.equals(d): "+c.equals(d));
        System.out.println("c==d: "+(c==d));
        System.out.println();
        System.out.println("c.equals(e): "+c.equals(e));
        System.out.println("c==e: "+(c==e));
        System.out.println();
        System.out.println("with '''' =: "+f+"'");

        if (aa.startsWith(" a") && bb.startsWith(" b")){
            System.out.println("startsWith: "+aa+bb);
        }else{
            System.out.println("NOT startsWith: "+aa+bb);
        }

    }
}
