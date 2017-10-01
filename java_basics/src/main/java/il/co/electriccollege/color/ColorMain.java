package il.co.electriccollege.color;

import java.awt.*;
import java.lang.reflect.Field;

/**
 * Created by yaakov on 9/28/17.
 */
public class ColorMain {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String colorName = args[0];

        Field colorInt = Color.class.getField(colorName);
        Color c = (Color)colorInt.get(null);
        String message = "RGB: (%s,%s,%s)";
        System.out.println(String.format(message, c.getRed(), c.getGreen(), c.getBlue()));
    }
}
