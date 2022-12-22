package objet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import swingg.Ecran;
import swingg.*;
import listener.*;

public class Mpandray implements Runnable {
    DataInputStream stylo;
    Socket origin;
    Ecran gamepanel;

    public Mpandray(Socket origin, Ecran gamepanel, DataInputStream stylo) {
        setOrigin(origin);
        setStylo(stylo);
        setGamepanel(gamepanel);
        if (getGamepanel() == null) {
            System.out.println("une des class est null");
        }
    }

    @Override
    public void run() {
        while (this.getOrigin().isConnected() == true) {
            
            try {
                receiveData(stylo);
            } catch (Exception e) {
                System.out.println("erreur dans la class Mpandray");
                System.out.println(e);
            }
        }
        try {
            this.getOrigin().shutdownInput();
        } catch (Exception e) {
            System.out.println("erreur dans la class Mpandray");
            System.out.println(e);
        }
    }

    public void receiveData(DataInputStream feutre) throws Exception {
        String valiny = feutre.readUTF();
        // System.out.println("valiny : " + valiny);

            int choix = Integer.valueOf(valiny);
            if (getGamepanel().getDiscussion().getP2().isNisafidy() == false) {
                getGamepanel().getDiscussion().getP2().setNisafidy(true);
                getGamepanel().getDiscussion().getP2().setChoix(choix);
                getGamepanel().getDiscussion().setNbNisafidy(getGamepanel().getDiscussion().getNbNisafidy() + 1);
            }
            if (getGamepanel().getDiscussion().getNbNisafidy() == 1)
            {
                String Smess = "";
                if(getGamepanel().getDiscussion().getP1().isNisafidy() == true)
                {
                    Smess = "En attente du choix du Joueur "+getGamepanel().getDiscussion().getP2().getNom();
                }
                else if(getGamepanel().getDiscussion().getP2().isNisafidy() == true)
                {
                    Smess = "Le Joueur "+getGamepanel().getDiscussion().getP2().getNom() +" a deja choisi";
                }
                getGamepanel().getDiscussion().resetStatutMessage(Smess);
            }
            if (getGamepanel().getDiscussion().getNbNisafidy() == 2 && getGamepanel().getDiscussion().getP1().isNisafidy() == true&& getGamepanel().getDiscussion().getP2().isNisafidy() == true) 
            {
                changeStats();
            } else {
                System.out.println("nothing happends");
            }
    }

    public void changeStats() {
        String rep = getGamepanel().getDiscussion().getP1().checkIfWIn(getGamepanel().getDiscussion().getP2());
        String mess = "";
        if (rep.equalsIgnoreCase("win")) {
            mess = "Congrats!! You win this turn against " + getGamepanel().getDiscussion().getP2().getNom();
            getGamepanel().getDiscussion().getP1().setScore(getGamepanel().getDiscussion().getP1().getScore() + 1);
        } else if (rep.equalsIgnoreCase("loose")) {
            mess = "Too Bad!! You Loose against " + getGamepanel().getDiscussion().getP2().getNom();
            getGamepanel().getDiscussion().getP2().setScore(getGamepanel().getDiscussion().getP2().getScore() + 1);
        } else if (rep.equalsIgnoreCase("draw")) {
            mess = "Draw!! Nobody win this turn";
        } else {
            System.out.println("il y a une erreur dans la fonction changestats");
            mess = "There's an error in the class  Mpandray";
        }
        getGamepanel().getDiscussion().resetStatutMessage(mess);
        getGamepanel().getDiscussion().refreshInfo();
        getGamepanel().getDiscussion().setNbNisafidy(0);
        getGamepanel().getDiscussion().getP1().setNisafidy(false);
        getGamepanel().getDiscussion().getP2().setNisafidy(false);
        if (getGamepanel().getDiscussion().getP2().getScore()>=5)
        {
            int f = JOptionPane.showConfirmDialog(getGamepanel(),"you loose against "+getGamepanel().getDiscussion().getP2().getNom() +"Do you wanna replay? if no, it will exit", "Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (f==0)
            {
                getGamepanel().getDiscussion().changePInfo(0, 0);
                getGamepanel().getDiscussion().resetStatutMessage("En attente de pour un rematch");
            }
            if (f==1)
            {
                System.exit(0);
            }
        }
        else if (getGamepanel().getDiscussion().getP1().getScore()>=5)
        {
            int f = JOptionPane.showConfirmDialog(getGamepanel(),"Congrats!!! you win against "+getGamepanel().getDiscussion().getP2().getNom() +"Do you wanna replay? if no, it will exit", "Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            System.out.println(f);
            try 
           {
                // DataOutputStream outing = new DataOutputStream(getOrigin().getOutputStream());
                if (f==0)
                {
                    getGamepanel().getDiscussion().changePInfo(0, 0);
                    getGamepanel().getDiscussion().resetStatutMessage("En attente de "+getGamepanel().getDiscussion().getP2().getNom()+" pour un rematch");
                }
                if (f==1)
                {
                    System.exit(0);
                }
           } 
           catch (Exception e) 
           {
            System.out.println(e);
           }
        }
    }

    public Socket getOrigin() {
        return origin;
    }

    public void setOrigin(Socket origin) {
        this.origin = origin;
    }

    public void setStylo(DataInputStream stylo) {
        this.stylo = stylo;
    }

    public DataInputStream getStylo() {
        return stylo;
    }

    public Ecran getGamepanel() {
        return gamepanel;
    }

    public void setGamepanel(Ecran gamepanel) {
        this.gamepanel = gamepanel;
    }
}
