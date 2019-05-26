/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author ALKODS
 */
public class NewClient {
    
    String name;
    public NewClient(){
        
    }
    
    public void done(String text){
        try {
            // TODO code application logic here
            Socket sock = new Socket("localhost", 8080);

            DataInputStream is = new DataInputStream(sock.getInputStream());
            DataOutputStream os = new DataOutputStream(sock.getOutputStream());

            name = text;
            os.writeUTF(name);

            String read = is.readUTF();
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(read));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
