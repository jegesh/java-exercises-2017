package il.co.electriccollege.library.gil.sql;

import java.util.Scanner;

/**
 * Created by yaakov on 8/23/17.
 */
public class UserInputHandler {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please enter your first name > ");
        String first = scanner.nextLine();

        System.out.println("Please enter your last name > ");
        String last = scanner.nextLine();

        System.out.println("Hello " + first + " " + last);
    }
}
