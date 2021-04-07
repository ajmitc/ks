package ks.client.view;

import javax.swing.*;
import java.awt.*;

public class ViewUtil {
    public static void popupNotify(String message){
        JOptionPane.showMessageDialog(null, message);
    }

    public static boolean popupConfirm(String title, String message){
        int ret = JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
        return ret >= 1;
    }

    public static Object popupDropdown(String title, String message, Object[] options){
        Object selected = JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        return selected;
    }

    public static Color toColor(String name){
        if (name.equalsIgnoreCase("blue"))
            return Color.BLUE;
        if (name.equalsIgnoreCase("red"))
            return Color.RED;
        return Color.BLACK;
    }

    private ViewUtil(){}
}
