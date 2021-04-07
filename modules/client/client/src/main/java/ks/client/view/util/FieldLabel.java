package ks.client.view.util;

import javax.swing.*;

public class FieldLabel extends JLabel {
    public FieldLabel(){
        this("");
    }

    public FieldLabel(String text){
        super(text);
        setFont(ViewUtil.DEFAULT_FONT);
    }
}
