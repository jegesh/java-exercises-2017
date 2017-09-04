package il.co.electriccollege.restaurant.irena.hibernate.dao.enums;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by IrKha on 29.08.2017.
 */
@Entity
@Table(name = "category")
public enum CategoryEnum {
    BusinessLunch,
    Dessert,
    Grill;
}
