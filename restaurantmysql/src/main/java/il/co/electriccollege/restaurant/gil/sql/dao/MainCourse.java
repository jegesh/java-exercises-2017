package il.co.electriccollege.restaurant.gil.sql.dao;

/**
 * Created by Comp3 on 30/08/17.
 */
public class MainCourse extends AbstractDish {

    private boolean wantWater;

    public MainCourse (String name, double price, String description, Boolean wantWater){
        super (name, price, description);
        this.type=DishType.MAIN_COURSE;
        this.wantWater=wantWater;

    }

    public boolean isWantWater() {
        return wantWater;
    }

    public void setWantWater(boolean wantWater) {
        this.wantWater = wantWater;
    }
}
