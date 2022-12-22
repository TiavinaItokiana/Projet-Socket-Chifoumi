package swingg;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.*;

import objet.*;
import listener.*;

public class ChoiceBTN extends JButton {
    int typeName;
    String iconeIMG;

    public ChoiceBTN(int typeName, String iconeIMG) {
        // Variable de classe et clas mere
        setTypeName(typeName);
        setIconeIMG(iconeIMG);
        this.setIcon(new ImageIcon(this.getClass().getResource(iconeIMG)));
        // Font
        this.setSize(100, 100);
        this.setBackground(Color.YELLOW);
        // Component

        // Component adding

    }

    public int getTypeName() {
        return typeName;
    }

    public void setTypeName(int typeName) {
        this.typeName = typeName;
    }

    public String getIconeIMG() {
        return iconeIMG;
    }

    public void setIconeIMG(String iconeIMG) {
        this.iconeIMG = iconeIMG;
    }

}
