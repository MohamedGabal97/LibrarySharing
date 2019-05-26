/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdisser;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author ALKODS
 */
public class ProjectDisSer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

            ServerSocket ss = new ServerSocket(8080);
            while (true) {
                Socket sock = ss.accept();
                ServerThread thread = new ServerThread(sock);
                thread.start();
            }
        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }
    
}
