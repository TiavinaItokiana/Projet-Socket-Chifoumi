package objet;

import java.io.ObjectOutputStream;
import java.net.Socket;

import swingg.Ecran;
import swingg.*;
import listener.*;

public class Mpandefa implements Runnable {
    ObjectOutputStream outer;
    Socket origin;
    Ecran gamepanel;

    public Mpandefa(Socket origin) {
        setOrigin(origin);
        try {
            setOuter(new ObjectOutputStream(this.getOrigin().getOutputStream()));
        } catch (Exception e) {
            System.out.println("Erreur dans le constructeur de Mpandefa");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        while (this.getOrigin().isConnected() == true) {
            System.out.println("Thread 'Mpandefa' on");
        }
    }

    public Socket getOrigin() {
        return origin;
    }

    public void setOrigin(Socket origin) {
        this.origin = origin;
    }

    public void setOuter(ObjectOutputStream outer) {
        this.outer = outer;
    }

    public ObjectOutputStream getOuter() {
        return outer;
    }
}
