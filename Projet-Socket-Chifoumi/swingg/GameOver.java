package swingg;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;

public class GameOver extends JFrame 
{
    String finish;
    Chifoumi parents;
    public GameOver (String finish,Chifoumi parents)
    {
        setFinish(finish);
        setParents(parents);

        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(300,250);
        this.setResizable(false);
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(parents);

        JPanel panpan = new JPanel();
        panpan.setBackground(Color.LIGHT_GRAY);
        panpan.setSize(300, 250);
        panpan.setLayout(new GridLayout (1,1));
        panpan.setLocation(0, 0);
        JLabel go = new JLabel(getFinish());

        panpan.add(go);
        this.add(panpan);

        this.setVisible(true);
    }

    public void setFinish(String finish) 
    {
        this.finish = finish;
    }
    public String getFinish() 
    {
        return finish;
    }

    public Chifoumi getParents() {
        return parents;
    }
    public void setParents(Chifoumi parents) {
        this.parents = parents;
    }
}
