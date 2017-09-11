package il.co.electriccollege.library.sql;

import il.co.electriccollege.library.sql.dal.MediaDal;
import il.co.electriccollege.library.sql.dao.AbstractMedia;

import java.util.Scanner;

/**
 * Created by yaakov on 8/23/17.
 */
public class UserInputHandler {

    private Scanner scanner = new Scanner(System.in);
    private MediaDal dal = new MediaDal(new DatabaseConnector());

    public static void main(String[] args) {
        new UserInputHandler().start();
    }

    public UserInputHandler(){

    }

    public void start(){
        boolean quit = false;
        while(!quit){
            System.out.println("Welcome to the library.  What would you like to do?\n" +
                    "1. Checkout a book or other media [ch]\n" +
                    "2. Return a book [rt]\n" +
                    "3. Donate a book [dn]\n" +
                    "4. View a list of available media [ls]\n" +
                    "5. Leave the library [q]\n" +
                    "Please enter your choice below");
            String choice = scanner.nextLine();
            switch (choice){
                case "ch":
                    checkout();
                    break;
                case "rt":
                    returnMedia();
                    break;
                case "dn":

                    break;
                case "ls":

                    break;
                case "q":
                    quit = true;
                    System.out.println("Goodbye! Please come again!");
                    break;
                default:
                    System.out.println("Please enter a valid choice\n\n");
            }
        }
    }

    public void donate(){

    }

    public void returnMedia(){
        System.out.println("Please enter the id of the media to return >");
        String mediaId = scanner.nextLine();
        boolean returned = dal.returnMedia(Integer.parseInt(mediaId));
        if(returned){
            AbstractMedia media = dal.getById(Integer.parseInt(mediaId));
            if(media != null){
                String output = "You returned a %s with the title %s, published on %s.  Enjoy!\n\n";
                System.out.println(String.format(output, media.getType().name(), media.getName(), media.getPublicationDate()));
                return;
            }
        }
        System.out.println("I'm sorry, you cannot return that item\n\n");

    }

    public void checkout(){
        System.out.println("Please enter the id of the media you wish to checkout >");
        String mediaId = scanner.nextLine();
        boolean checkedOut = dal.checkoutMedia(Integer.parseInt(mediaId));
        if(checkedOut){
            AbstractMedia media = dal.getById(Integer.parseInt(mediaId));
            if(media != null){
                String output = "You checked out a %s with the title %s, published on %s.  Enjoy!\n\n";
                System.out.println(String.format(output, media.getType().name(), media.getName(), media.getPublicationDate()));
                return;
            }
        }
        System.out.println("I'm sorry, that item is not available presently");
    }
}
