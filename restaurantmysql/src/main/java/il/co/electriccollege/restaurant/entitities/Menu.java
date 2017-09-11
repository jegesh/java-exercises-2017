package il.co.electriccollege.restaurant.entitities;

import il.co.electriccollege.restaurant.dishes.AbstractDish;

import javax.persistence.*;
//import javax.persistence.*;


@Entity
@Table(name="menu")
public class Menu {
//
//        int id;
//        Dishes dish;
//        String dishName;
//
//
//        @ManyToOne
//        @JoinColumn(name = "dishId")
//        public Dishes getDish() {
//            return dish;
//        }
//
//          public void setDish(Dishes dish) {
//        this.dish = dish;
//    }
//
//        @Id
//         @GeneratedValue(strategy=GenerationType.AUTO)
//        @Column
//        public  int    getId() {
//            return id;
//
//        }
//
//        public void   setId(int id) {
//            this.id = id;
//        }
//
//    @Column(name = "name")
//    public String getDishName() {
//        return dishName;
//    }
//
//
//    public void setDishName(String dishName) {
//        this.dishName = dishName;
//    }



        int id;
        String hours_available;
        String name;

         @Column
        public String getHoursAvailable() {
            return hours_available;
        }

          public void setHoursAvailable(String hours_available) {
        this.hours_available = hours_available;
    }

        @Id
         @GeneratedValue(strategy=GenerationType.AUTO)
        @Column
        public  int    getId() {
            return id;

        }

        public void   setId(int id) {
            this.id = id;
        }

        @Column(name = "name")
        public String getName() {
            return name;
        }


        public void setName(String name) {
            this.name = name;
        }
}
