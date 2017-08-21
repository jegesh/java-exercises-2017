package il.co.electriccollege.sql.jdo.entities;

import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Created by yaakov on 8/19/17.
 */
@PersistenceCapable(identityType= IdentityType.APPLICATION)
public class Dish {

    public Dish(){
        super();
    }

     @Persistent
     @PrimaryKey
     private long id;

     @Persistent
     private String name;

     @Persistent
     private String category;

    @Persistent
    private String description;

    @Persistent
    private float price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
