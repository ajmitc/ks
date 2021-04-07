package ks.client.view.util;

import javax.swing.*;

public class TitleLabel extends JLabel {
    public TitleLabel(){
        this("");
    }

    public TitleLabel(String text){
        super(text);
        setFont(ViewUtil.TITLE_FONT);
    }
}
