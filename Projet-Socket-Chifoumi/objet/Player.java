package objet;

import java.io.Serializable;
import swingg.*;
import listener.*;

public class Player implements Serializable {
    String nom;
    int score;
    int choix; /* 1=pierre, 2=papier, 3=ciseaux, o=pas de choix */
    boolean nisafidy = false;

    public Player(String nom) {
        setNom(nom);
    }

    public Player(String nom, int score) {
        setNom(nom);
        setScore(score);
    }

    public Player(String nom, int score, int choix) {
        setNom(nom);
        setScore(score);
        setChoix(choix);
    }

    public String checkIfWIn(Player p2) {
        String verdict = "";
        // Supposons que this est le P1
        if (this.choix == 0 || p2.getChoix() == 0) {
            System.out.println("Tous les joueurs n'ont pas encore choisi");
        } else {
            if (this.getChoix() == 1)// PIERRE
            {
                if (p2.getChoix() == 1) {
                    // P1 PIERRE et P2 PIERRE
                    verdict = "draw";
                } else if (p2.getChoix() == 2) {
                    // P1 PIERRE et P2 PAPIER
                    verdict = "loose";
                } else if (p2.getChoix() == 3) {
                    // P1 PIERRE et P2 CISEAUX
                    verdict = "win";
                }
            } else if (this.getChoix() == 2)// PAPIER
            {
                if (p2.getChoix() == 1) {
                    // P1 PAPIER et P2 PIERRE
                    verdict = "win";
                } else if (p2.getChoix() == 2) {
                    // P1 PAPIER et P2 PAPIER
                    verdict = "draw";
                } else if (p2.getChoix() == 3) {
                    // P1 PAPIER et P2 CISEAU
                    verdict = "loose";
                }
            } else if (this.getChoix() == 3)// CISEAUX
            {
                if (p2.getChoix() == 1) {
                    // P1 CISEAUX et P2 PIERRE
                    verdict = "loose";
                } else if (p2.getChoix() == 2) {
                    // P1 CISEAUX et P2 PAPIER
                    verdict = "win";
                } else if (p2.getChoix() == 3) {
                    // P1 CISEAUX et P2 CISEAUX
                    verdict = "draw";
                }
            }
            p2.setChoix(0);
            this.setChoix(0);
        }
        return verdict;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getChoix() {
        return choix;
    }

    public void setChoix(int choix) {
        this.choix = choix;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setNisafidy(boolean nisafidy) {
        this.nisafidy = nisafidy;
    }

    public boolean isNisafidy() {
        return nisafidy;
    }
}
