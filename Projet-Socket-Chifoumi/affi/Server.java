package affi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import swingg.Chifoumi;

public class Server 
{
    public static void main(String[] args) 
    {
        try 
        {
            String j1name = JOptionPane.showInputDialog("Entrer votre nom de joueur (Server)");
            ServerSocket SSocket = new ServerSocket(1234);
            System.out.println("Waiting for clients");
            Socket client = SSocket.accept();
            
            DataOutputStream mandefa = new DataOutputStream(client.getOutputStream());
            DataInputStream maka = new DataInputStream(client.getInputStream());
            
            String j2name = null;
            mandefa.writeUTF(j1name);
            mandefa.flush();
            
            System.out.println("You are connected with "+client.getLocalAddress().getHostName());
            
            while (j2name==null)
            {
                // System.out.println("Mbola tsy misy adversaire ilay server ohhhh");
                j2name = maka.readUTF();
                System.out.println("Adversaire : "+j2name);
            }
            Chifoumi jankenpo = new Chifoumi(client,j1name,j2name,"Server",mandefa,maka);
        } 
        catch (Exception e) 
        {
            System.out.println("erreur dans la class Server");
            System.err.println(e);
        }
    }
}
