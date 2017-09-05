package il.co.electriccollege.restaurant.irena.hibernate.dao.enums;

import javax.persistence.*;

/**
 * Created by IrKha on 29.08.2017.
 */
@Entity
@Table(name = "category")
public enum CategoryEnum {

    @Column(name="category_name")
    BusinessLunch,
    Dessert,
    Grill;
    private int id;

    @Id
    @GeneratedValue
    @Column(name = "category_id")
    public int getId(){
        return this.ordinal()+1;
    }
    public void setId(int id){
        this.id = this.ordinal()+1;
    }
}
