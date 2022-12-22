package swingg;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import objet.Player;
import objet.*;
import listener.*;

public class Dialogue extends JPanel {
    String p1name;
    String p2name;
    Ecran gameScreen;
    Player p1;
    Player p2;
    JLabel infoP1;
    JLabel infoP2;
    JLabel statutMatch;

    int nbNisafidy = 0;

    public Dialogue(Ecran gameScreen, String p1Name, String p2Name) {
        // variable de class (initialiser)

        setGameScreen(gameScreen);
        setP1name(p1name);
        setP2name(p2name);
        // System.out.println(p1Name);
        setP1(new Player(p1Name));
        // System.out.println(p1.getNom());
        setP2(new Player(p2Name));
        setInfoP1(new JLabel("boom"));
        setInfoP2(new JLabel("boom2"));
        setStatutMatch(new JLabel("Vous venez de commencer la partie avec  " + p2.getNom()));
        this.changePInfo(0, 0);

        // font
        this.setSize(getGameScreen().getWidth() / 2, getGameScreen().getHeight() / 2);
        this.setLayout(new GridLayout(3, 1));

        // Object instance

        // Ajout de tous les objets
        this.add(getStatutMatch());
        this.add(getInfoP1());
        this.add(getInfoP2());
    }

    public void changePInfo(int scorep1, int scorep2) {
        p1.setScore(scorep1);
        p2.setScore(scorep2);
        infoP1.setText("J1(Vous): " + p1.getNom() + " Score: " + p1.getScore());
        infoP2.setText("J2: " + p2.getNom() + " Score: " + p2.getScore());
    }

    public void refreshInfo() {
        infoP1.setText("J1(Vous): " + p1.getNom() + " Score: " + p1.getScore());
        infoP2.setText("J2: " + p2.getNom() + " Score: " + p2.getScore());
    }

    public void changeP1Info(int scorep1) {
        p1.setScore(scorep1);
        infoP1.setText("J1(Vous): " + p1.getNom() + " Score: " + p1.getScore());
        infoP2.setText("J2: " + p2.getNom() + " Score: " + p2.getScore());
    }

    public void resetStatutMessage(String message) {
        getStatutMatch().setText(message);
    }

    public void changeP2Info(int scorep2) {
        p2.setScore(scorep2);
        infoP1.setText("J1(Vous): " + p1.getNom() + " Score: " + p1.getScore());
        infoP2.setText("J2: " + p2.getNom() + " Score: " + p2.getScore());
    }

    public Ecran getGameScreen() {
        return gameScreen;
    }

    public void setGameScreen(Ecran gameScreen) {
        this.gameScreen = gameScreen;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public JLabel getInfoP1() {
        return infoP1;
    }

    public void setInfoP1(JLabel infoP1) {
        this.infoP1 = infoP1;
    }

    public JLabel getInfoP2() {
        return infoP2;
    }

    public void setInfoP2(JLabel infoP2) {
        this.infoP2 = infoP2;
    }

    public JLabel getStatutMatch() {
        return statutMatch;
    }

    public void setStatutMatch(JLabel statutMatch) {
        this.statutMatch = statutMatch;
    }

    public String getP1name() {
        return p1name;
    }

    public void setP1name(String p1name) {
        this.p1name = p1name;
    }

    public String getP2name() {
        return p2name;
    }

    public void setP2name(String p2name) {
        this.p2name = p2name;
    }

    public int getNbNisafidy() {
        return nbNisafidy;
    }

    public void setNbNisafidy(int nbNisafidy) {
        this.nbNisafidy = nbNisafidy;
    }

}
