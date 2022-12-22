package swingg;

import java.awt.*;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JPanel;
import objet.*;
import listener.*;

public class Ecran extends JPanel {
    String nomJ1;
    String nomJ2;
    Chifoumi chifoumi;
    Dialogue discussion;
    Commande manette;
    Socket localSocket;
    DataOutputStream dataSender;

    public Ecran(String nomJ1, String nomJ2, Chifoumi chifoumi, Socket localSocket, DataOutputStream dataSender) {
        // variable de class
        setNomJ1(nomJ1);
        setNomJ2(nomJ2);
        setChifoumi(chifoumi);
        setLocalSocket(localSocket);
        setDataSender(dataSender);

        // font

        this.setSize(this.getChifoumi().getWidth(), this.getChifoumi().getHeight());
        this.setBackground(Color.black);
        this.setLayout(new GridLayout(2, 1));

        // instance component
        discussion = new Dialogue(this, getNomJ1(), getNomJ2());
        manette = new Commande(this.getChifoumi(), discussion, this.getLocalSocket(), getDataSender());
        // adding component
        this.add(discussion);
        this.add(manette);
    }

    public Dialogue getDiscussion() {
        return discussion;
    }

    public void setDiscussion(Dialogue discussion) {
        this.discussion = discussion;
    }

    public void setChifoumi(Chifoumi chifoumi) {
        this.chifoumi = chifoumi;
    }

    public Chifoumi getChifoumi() {
        return chifoumi;
    }

    public void setNomJ1(String nomJ1) {
        this.nomJ1 = nomJ1;
    }

    public String getNomJ1() {
        return nomJ1;
    }

    public void setNomJ2(String nomJ2) {
        this.nomJ2 = nomJ2;
    }

    public String getNomJ2() {
        return nomJ2;
    }

    public Socket getLocalSocket() {
        return localSocket;
    }

    public void setLocalSocket(Socket localSocket) {
        this.localSocket = localSocket;
    }

    public DataOutputStream getDataSender() {
        return dataSender;
    }

    public void setDataSender(DataOutputStream dataSender) {
        this.dataSender = dataSender;
    }
}
