package il.co.electriccollege.restaurant.dishes;

public class BusinessLunch extends AbstractDish {
        private SideDish sideDish;
        private  StandardDish standardDish;
        private String name;
        private float price;



        public BusinessLunch(String name, float price,  DishCatagory catagory) {

            super(name, price, catagory);
            this.name=name;
            this.price=price;
        }

        public BusinessLunch(String name, float price, DishCatagory catagory, SideDish sideDish,  StandardDish standardDish ) {
            super(name, price, catagory);
            this.sideDish= sideDish;
            this.standardDish= standardDish;
        }

        public BusinessLunch(int id, String name, float price, DishCatagory catagory) {
            super(id, name,price, catagory);
            this.name=name;
            this.price=price;


        }

        /**
         * adds dish to order at no additional price
         * @param sideDish
         */
        public void setSideDish(SideDish sideDish){
            this.sideDish=sideDish;
        }


        public void setStandardDish(StandardDish standardDish){
            this.standardDish=standardDish;
        }
}
