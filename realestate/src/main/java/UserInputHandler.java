import org.hibernate.Session;

public class UserInputHandler {
    private DbSessionManager sessionManager;

    public static void main(String[] args) {
        new UserInputHandler(args[0]).start();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("bla**********************************************************************************************************");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }



    public UserInputHandler(String configFile){
        sessionManager = new DbSessionManager(configFile);
    }

    private void start() {
        Session session = DbSessionManager.getSessionFactoryInstance().openSession();
        Dish dish= new Dish();
        dish.setName("dish");
        session.save(dish);
        session.close();
        }

    }

