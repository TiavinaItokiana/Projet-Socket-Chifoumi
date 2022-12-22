package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import swingg.ChoiceBTN;
import swingg.Dialogue;

public class PushedBTN implements ActionListener 
{

    Socket origine;
    ChoiceBTN clickme;
    DataOutputStream plume;
    Dialogue boiteDial;
    public PushedBTN (ChoiceBTN clickme,Socket origine,DataOutputStream plume,Dialogue boiteDial)
    {
        setClickme(clickme);
        setOrigine(origine);
        setPlume(plume);
        setBoiteDial(boiteDial);
        if(boiteDial==null)
        {
            System.out.println("Erreur dans le constructeur de PushedBTN : Dialogure boiteDial = null");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            if(getBoiteDial().getP1().isNisafidy()==false)
            {
                sendChoix(plume);
                getBoiteDial().getP1().setNisafidy(true);
                getBoiteDial().getP1().setChoix(clickme.getTypeName());
                getBoiteDial().setNbNisafidy(getBoiteDial().getNbNisafidy()+1);
            }
            if(this.getBoiteDial().getNbNisafidy()==2 && this.getBoiteDial().getP1().isNisafidy()==true && this.getBoiteDial().getP2().isNisafidy()==true)
            {
                /* String f [] = new String [4];
                f[0] = "pas de choix encore";
                f[1] = "pierre";
                f[2] = "feuille";
                f[3] = "ciseau";
                System.out.println("J1 : "+f[this.getBoiteDial().getP1().getChoix()] +" VS J2 : "+f[this.getBoiteDial().getP1().getChoix()]); */
                changeStats();
            }
            if (getBoiteDial().getNbNisafidy() == 1)
            {
                String Smess = "";
                if(getBoiteDial().getP1().isNisafidy() == true)
                {
                    Smess = "En attente du choix du Joueur "+getBoiteDial().getP2().getNom();
                }
                else if(getBoiteDial().getP2().isNisafidy() == true)
                {
                    Smess = "Le Joueur "+getBoiteDial().getP2().getNom() +" a deja choisi";
                }
                getBoiteDial().resetStatutMessage(Smess);
            }
            else
            {
                // String Smess = "You can't chose anymore cuz you already did it";
                System.out.println("You can't chose anymore cuz you already did it");
                // getBoiteDial().resetStatutMessage(Smess);
            }
        } 
        catch (Exception e1) 
        {
            System.out.println("Erreur dans la classe PushedBTN");
            System.out.println(e1);
        }
    }

    public void changeStats ()
    {
        String rep = this.getBoiteDial().getP1().checkIfWIn(this.getBoiteDial().getP2());
        String mess = "";
        if (rep.equalsIgnoreCase("win"))
        {
            mess = "Congrats!! You win this turn against "+this.getBoiteDial().getP2().getNom();
            this.getBoiteDial().getP1().setScore(this.getBoiteDial().getP1().getScore()+1);
        }
        else if (rep.equalsIgnoreCase("loose"))
        {
            mess = "Too Bad!! You Loose against "+this.getBoiteDial().getP2().getNom();
            this.getBoiteDial().getP2().setScore(this.getBoiteDial().getP2().getScore()+1);
        }
        else if (rep.equalsIgnoreCase("draw"))
        {
            mess = "Draw!! Nobody win this turn";
        }
        else 
        {
            System.out.println("il y a une erreur dans la fonction changestats");
            mess= "There's an error in the class  Mpandray";
        }
        this.getBoiteDial().resetStatutMessage(mess);
        this.getBoiteDial().refreshInfo();
        this.getBoiteDial().setNbNisafidy(0);
        this.getBoiteDial().getP1().setNisafidy(false);
        this.getBoiteDial().getP2().setNisafidy(false);
        if (getBoiteDial().getP2().getScore()>=5)
        {
            int f = JOptionPane.showConfirmDialog(this.getBoiteDial().getGameScreen(),"you loose against "+this.getBoiteDial().getP2().getNom() +"Do you wanna replay? if no, it will exit", "Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if (f==0)
            {
                getBoiteDial().changePInfo(0, 0);
                getBoiteDial().resetStatutMessage("En attente de pour un rematch");
            }
            if (f==1)
            {
                System.exit(0);
            }
        }
        else if (getBoiteDial().getP1().getScore()>=5)
        {
            // System.out.println("naresy annnhhhhhhh");
            int f = JOptionPane.showConfirmDialog(this.getBoiteDial().getGameScreen(),"Congrats!!! you win against "+this.getBoiteDial().getP2().getNom() +"Do you wanna replay? if no, it will exit", "Game Over",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            try 
           {
                // DataOutputStream outing = new DataOutputStream(getOrigine().getOutputStream());
                if (f==0)
                {
                    getBoiteDial().changePInfo(0, 0);
                    getBoiteDial().resetStatutMessage("En attente de "+getBoiteDial().getP2().getNom()+" pour un rematch");
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

    public void sendChoix (DataOutputStream plume)throws Exception
    {
        plume.writeUTF(""+this.getClickme().getTypeName());
        plume.flush();
        // System.out.println(" anyyyyy");
    }

    public void setClickme(ChoiceBTN clickme) {
        this.clickme = clickme;
    }
    public void setOrigine(Socket origine) {
        this.origine = origine;
    }
    
    public ChoiceBTN getClickme() {
        return clickme;
    }
    public Socket getOrigine() {
        return origine;
    }
    public void setPlume(DataOutputStream plume) {
        this.plume = plume;
    }
    public DataOutputStream getPlume() {
        return plume;
    }

    public Dialogue getBoiteDial() {
        return boiteDial;
    }
    public void setBoiteDial(Dialogue boiteDial) {
        this.boiteDial = boiteDial;
    }
    
}
