package affi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import swingg.Chifoumi;

public class Client 
{
    public static void main(String[] args) 
    {
        String ip = JOptionPane.showInputDialog("Entrer l'IP de l'Host");
        //String port = JOptionPane.showInputDialog("Entrer le port de l'Host");
        String j1name = JOptionPane.showInputDialog("Entrer votre nom de joueur (Client)");
        try 
        {
            int h = 1234;
            Socket me = new Socket(ip, h); 
            
            System.out.println("Vous etes connectee"); 
            DataOutputStream mandefa = new DataOutputStream(me.getOutputStream());
            DataInputStream maka = new DataInputStream(me.getInputStream());
            String j2name = null;
            mandefa.writeUTF(j1name);
            mandefa.flush();
            while (j2name==null)
            {
                // System.out.println("Mbola tsy misy adversaire ilay client ohhhh");
                j2name = maka.readUTF();
                System.out.println("Adversaire : "+j2name);
            }
            Chifoumi jankenpo = new Chifoumi(me,j1name,j2name,"Client",mandefa,maka);
        } 
        catch (Exception e) 
        {
            System.out.println("erreur dans la class Client");
            System.out.println(e);
        }
    }
}
