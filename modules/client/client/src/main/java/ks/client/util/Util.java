package ks.client.util;

import java.awt.*;

public class Util {
    public static String getColorName(Color color){
        if (color == Color.RED)
            return "Red";
        if (color == Color.BLUE)
            return "Blue";
        if (color == Color.GREEN)
            return "Green";
        return "Add color to Utils::getColorName";
    }

    private Util(){}
}
