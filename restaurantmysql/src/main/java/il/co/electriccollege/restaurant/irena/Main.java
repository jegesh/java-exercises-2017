package il.co.electriccollege.restaurant.irena;

import il.co.electriccollege.restaurant.irena.dal.DishesDal;
import il.co.electriccollege.restaurant.irena.dao.Dish;
import il.co.electriccollege.restaurant.irena.hibernate.dao.enums.*;
import il.co.electriccollege.restaurant.irena.model.DatabaseConnector;

import java.util.ArrayList;

/**
 * Created by IrKha on 29.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        DishesDal dishesDal = new DishesDal(new DatabaseConnector());
        ArrayList<Dish> dishes = (ArrayList<Dish>) dishesDal.getAllDishes();
        for(Dish d : dishes){
            System.out.println(d);
        }
       /* Dish business = new BusinessLunch(Garnish.RISE);
        business.setName("Business #4");
        business.setPrice(252);
        business.setDescription("soup 2 sausages and puree");

        Dish desert = new Dessert(DrinkEnum.TEA);
        desert.setName("Cake");
        desert.setPrice(10);
        desert.setDescription("Apple Pie");

        Dish solomon = new Grill(Roasting.WellDone);
        solomon.setName("Solomon on grill");
        solomon.setPrice(150);

        dishesDal.addDish(solomon);
        dishesDal.addDish(desert);
        dishesDal.addDish(business);*/
        System.out.println("--------cheapest-------");
        ArrayList<Dish> dishes1 = (ArrayList<Dish>) dishesDal.getTops(SortingEnum.DESC,5);
        for (Dish dish:dishes1){
            System.out.println(dish);
        }
        System.out.println("-------category---------");
        dishes = dishesDal.getDishByCategory(CategoryEnum.BusinessLunch);
        for(Dish d : dishes){
            System.out.println(d);
        }
        dishes = dishesDal.getDishByCategory(CategoryEnum.Dessert);
        for(Dish d : dishes){
            System.out.println(d);
        }
        Dish forUpdate = dishesDal.getById(2);
        dishesDal.updatePrice(forUpdate, 222);
        dishesDal.removeDish(forUpdate);
    }
}
