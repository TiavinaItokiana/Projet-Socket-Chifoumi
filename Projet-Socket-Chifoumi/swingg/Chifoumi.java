package swingg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import javax.swing.JFrame;

import objet.Mpandefa;
import objet.Mpandray;

import objet.*;
import listener.*;

public class Chifoumi extends JFrame {
    Socket connect;
    String myName;
    String typeSocket;
    String opponent;

    DataOutputStream stylo;
    DataInputStream reader;

    public Chifoumi(Socket connect, String myName, String opponent, String typeSocket, DataOutputStream stylo,
            DataInputStream reader) {
        super("" + myName + " (" + typeSocket + ")");
        // Variable de class
        setConnect(connect);
        setMyName(myName);
        setOpponent(opponent);
        setTypeSocket(typeSocket);
        setStylo(stylo);
        setReader(reader);
        // Font

        this.setLayout(null);
        this.setSize(600, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(true);

        // Instance Component

        Ecran screen = new Ecran(getMyName(), getOpponent(), this, this.getConnect(), this.getStylo());

        // Addind component

        this.add(screen);

        // Visibility

        this.setVisible(true);

        // Other Object

        // Mpandefa outing = new Mpandefa(this.connect);
        Mpandray entering = new Mpandray(this.connect, screen, this.getReader());
        // Thread mandefa = new Thread(outing);
        Thread mandray = new Thread(entering);
        // mandefa.start();
        mandray.start();
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public String getTypeSocket() {
        return typeSocket;
    }

    public void setTypeSocket(String typeSocket) {
        this.typeSocket = typeSocket;
    }

    public String getMyName() {
        return myName;
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public Socket getConnect() {
        return connect;
    }

    public void setConnect(Socket connect) {
        this.connect = connect;
    }

    public void setStylo(DataOutputStream stylo) {
        this.stylo = stylo;
    }

    public DataOutputStream getStylo() {
        return stylo;
    }

    public DataInputStream getReader() {
        return reader;
    }

    public void setReader(DataInputStream reader) {
        this.reader = reader;
    }
}