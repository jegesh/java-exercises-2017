package il.co.electriccollege.restaurant.entitities;

import il.co.electriccollege.restaurant.dishes.DishCatagory;
import javax.persistence.*;

@Entity
@Table (name="dishes")//(name= "il/co/electriccollege/restaurant/dishes")
public class Dishes {
        private int id;
        private  String name;
        private  String description;
        private  float price;
        private DishCatagory dishCatagory;

//    public Dishes()
//    {
//
//    }

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        @Column
        public int getId() {
            return id;
        }


        public void setId(int id) {
            this.id = id;
        }

        @Column(name="name")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Column(name="description")
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Column(name="price")
        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        @Column(name="catagory")
        public DishCatagory getDishCatagory() {
            return dishCatagory;
        }

        public void setDishCatagory(DishCatagory dishCatagory) {
            this.dishCatagory = dishCatagory;
        }



    }


