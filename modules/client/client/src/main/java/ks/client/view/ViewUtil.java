package ks.client.view;

import javax.swing.*;

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

    private ViewUtil(){}
}