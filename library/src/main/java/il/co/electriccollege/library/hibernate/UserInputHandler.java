package il.co.electriccollege.library.hibernate;


import il.co.electriccollege.library.Main;
import il.co.electriccollege.library.hibernate.entitities.Library;
import il.co.electriccollege.library.hibernate.entitities.Media;
import il.co.electriccollege.library.hibernate.entitities.MediaStatus;
import il.co.electriccollege.library.hibernate.entitities.MediaType;
import org.hibernate.Session;
import org.hibernate.query.criteria.internal.CriteriaQueryImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yaakov on 8/23/17.
 */
public class UserInputHandler {

    private Scanner scanner = new Scanner(System.in);
    private DbSessionManager sessionManager;

    public static void main(String[] args) {
        new UserInputHandler(args[0]).start();
    }

    public UserInputHandler(String configFile){
        sessionManager = new DbSessionManager(configFile);
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
            try {
                switch (choice) {
                    case "ch":
                        checkout();
                        break;
                    case "rt":
                        returnMedia();
                        break;
                    case "dn":
                        donate();
                        break;
                    case "ls":
                        list();
                        break;
                    case "q":
                        quit = true;
                        System.out.println("Goodbye! Please come again!");
                        break;
                    default:
                        System.out.println("Please enter a valid choice\n\n");
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }

    public void donate() throws ParseException {
        Session session = DbSessionManager.getSessionFactoryInstance().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Library> criteria = builder.createQuery(Library.class);
        Root<Library> root = criteria.from(Library.class);
        criteria.select(root);
        List<Library> libraries = session.createQuery(criteria).getResultList();
        System.out.println("Available libraries:");
        for(Library l: libraries){
            System.out.println(l);
        }
        System.out.println("\n\n");
        System.out.println("To which library would you like to donate? (by id)");
        String libraryId = scanner.nextLine();
        Library library = null;
        for(Library l: libraries){
            if(l.getId() == Integer.parseInt(libraryId)){
                library = l;
            }
        }
        if(library == null){
            System.out.println("Invalid library id!\n\n");
            return;
        }

        System.out.println("Enter the number of the kind of media you would you like to donate >\n" +
                "1. Book\n" +
                "2. Audiobook\n" +
                "3. Magazine");
        String mediaNumber = scanner.nextLine();
        Media media = new Media();
        media.setLibrary(library);
        media.setStatus(MediaStatus.AVAILABLE.name());
        switch (mediaNumber){
            case "1":
                media.setMediaType(MediaType.BOOK.name());
                break;
            case "2":
                media.setMediaType(MediaType.AUDIOBOOK.name());
                break;
            case "3":
                media.setMediaType(MediaType.MAGAZINE.name());
                break;
            default:
                // if the answer was none of the above
                System.out.println("Invalid choice!\n\n");
                return;
        }
        System.out.println("Please enter a title for the media >");
        String title = scanner.nextLine();
        System.out.println("Please enter the publication date of the media (like 30/01/2017) >");
        String dateString = scanner.nextLine();
        media.setPublicationDate(Main.getDateWithSimpleFormat(dateString));
        media.setName(title);
        session.save(media);

        System.out.println("Thank you for your donation!\n\n");
        session.close();
    }

    private void list(){
        System.out.println("Would you like to view library items by type or name? [t,n]");
        String choice = scanner.nextLine();
        if(!choice.toLowerCase().equals("t") && !choice.toLowerCase().equals("n")){
            System.out.println("Invalid option!\n\n");
            return;
        }
        Session session = DbSessionManager.getSessionFactoryInstance().openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Media> criteria = builder.createQuery(Media.class);
        Root<Media> root = criteria.from(Media.class);
        criteria.select( root );

        switch (choice.toLowerCase()){
            case "t":
                // list by type
                System.out.println("Which type of media are you interested in: audiobooks, regular books, or magazines? [a,b,m]");
                String mediaChoice = scanner.nextLine();
                if(!mediaChoice.toLowerCase().equals("a") && !mediaChoice.toLowerCase().equals("b") && !mediaChoice.toLowerCase().equals("m")){
                    System.out.println("Invalid option!\n\n");
                    return;
                }
                String mediaType = null;
                switch (mediaChoice){
                    case "a":
                        mediaType = MediaType.AUDIOBOOK.name();
                        break;
                    case "b":
                        mediaType = MediaType.BOOK.name();
                        break;
                    case "m":
                        mediaType = MediaType.MAGAZINE.name();
                        break;
                }

                criteria.where(builder.equal(root.get("mediaType"), mediaType));
                List<Media> mediaList = session.createQuery( criteria ).getResultList();
                for (Media m: mediaList){
                    System.out.println(m);
                }
                System.out.println("\n\n");
                break;
            case "n":
                // list by name
                System.out.println("Enter a title to search for >");
                String searchTerm = scanner.nextLine();
                criteria.where(builder.like(root.get("name"), searchTerm));
                List<Media> searchResults = session.createQuery( criteria ).getResultList();
                for (Media m: searchResults){
                    System.out.println(m);
                }
                System.out.println("\n\n");
        }
        session.close();
    }

    private void returnMedia(){
        System.out.println("Please enter the id of the media to return >");
        String mediaId = scanner.nextLine();
        Session session = DbSessionManager.getSessionFactoryInstance().openSession();
        Media media = session.get(Media.class, Long.parseLong(mediaId));
        if(media != null && media.getStatus().equals(MediaStatus.AVAILABLE)){
            media.setStatus(MediaStatus.LOANED.name());
            session.update(media);
            session.getTransaction().commit();
            session.beginTransaction();
            String output = "You returned a %s with the title %s, published on %s.  Enjoy!\n\n";
            System.out.println(String.format(output, media.getMediaType(), media.getName(), media.getPublicationDate()));
            return;
        }
        System.out.println("I'm sorry, you cannot return that item\n\n");
        session.close();
    }

    private void checkout(){
        System.out.println("Please enter the id of the media you wish to checkout >");
        String mediaId = scanner.nextLine();
        Session session = DbSessionManager.getSessionFactoryInstance().openSession();
        Media media = session.get(Media.class, Long.parseLong(mediaId));
        if(media != null && media.getStatus().equals(MediaStatus.AVAILABLE.name())){
            media.setStatus(MediaStatus.LOANED.name());
            session.update(media);
            session.getTransaction().commit();
            session.beginTransaction();
            String output = "You checked out a %s with the title %s, published on %s.  Enjoy!\n\n";
            System.out.println(String.format(output, media.getMediaType(), media.getName(), media.getPublicationDate()));
            return;
        }
        System.out.println("I'm sorry, that item is not available presently");
        session.close();
    }
}
