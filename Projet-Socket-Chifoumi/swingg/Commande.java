package swingg;

import java.net.Socket;

import javax.swing.JPanel;

import listener.PushedBTN;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import objet.*;
import listener.*;;

public class Commande extends JPanel {
    Chifoumi jankenpo;
    Dialogue dial;
    Socket reseau;

    String pathPierre = "/src/Pierre.png";
    String pathPapier = "/src/Feuille.png";
    String pathCiseaux = "/src/Ciseaux.png";

    ChoiceBTN pierre;
    ChoiceBTN papier;
    ChoiceBTN ciseaux;

    DataOutputStream dataSender;

    public Commande(Chifoumi jankenpo, Dialogue dial, Socket reseau, DataOutputStream dataSender) {
        // Variable de class
        setJankenpo(jankenpo);
        setReseau(reseau);
        setDial(dial);
        setDataSender(dataSender);

        // Font
        this.setPreferredSize(new Dimension(500, 200));
        this.setSize(jankenpo.getWidth() / 2, jankenpo.getHeight() / 2);
        this.setBackground(Color.blue);
        this.setLayout(new GridLayout(1, 3));
        Font b = new Font("ink free",Font.BOLD,10);
        this.setFont(b);

        // Instance component
        pierre = new ChoiceBTN(1, pathPierre);
        papier = new ChoiceBTN(2, pathPapier);
        ciseaux = new ChoiceBTN(3, pathCiseaux);

        PushedBTN pierreListen = new PushedBTN(pierre, reseau, this.getDataSender(), getDial());
        PushedBTN papierListen = new PushedBTN(papier, reseau, this.getDataSender(), getDial());
        PushedBTN ciseauxListen = new PushedBTN(ciseaux, reseau, this.getDataSender(), getDial());

        pierre.addActionListener(pierreListen);
        papier.addActionListener(papierListen);
        ciseaux.addActionListener(ciseauxListen);
        // Adding object
        this.add(pierre);
        this.add(papier);
        this.add(ciseaux);

    }

    public Chifoumi getJankenpo() {
        return jankenpo;
    }

    public void setJankenpo(Chifoumi jankenpo) {
        this.jankenpo = jankenpo;
    }

    public void setReseau(Socket reseau) {
        this.reseau = reseau;
    }

    public Socket getReseau() {
        return reseau;
    }

    public ChoiceBTN getPierre() {
        return pierre;
    }

    public void setPierre(ChoiceBTN pierre) {
        this.pierre = pierre;
    }

    public ChoiceBTN getPapier() {
        return papier;
    }

    public void setPapier(ChoiceBTN papier) {
        this.papier = papier;
    }

    public ChoiceBTN getCiseaux() {
        return ciseaux;
    }

    public void setCiseaux(ChoiceBTN ciseaux) {
        this.ciseaux = ciseaux;
    }

    public DataOutputStream getDataSender() {
        return dataSender;
    }

    public void setDataSender(DataOutputStream dataSender) {
        this.dataSender = dataSender;
    }

    public Dialogue getDial() {
        return dial;
    }

    public void setDial(Dialogue dial) {
        this.dial = dial;
    }

}
