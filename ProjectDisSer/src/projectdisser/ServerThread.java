/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectdisser;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALKODS
 */
public class ServerThread extends Thread{
    Socket socket;

    public ServerThread(Socket sok) {
        socket = sok;
    }

    @Override
    public void run(){
        try {
            List<Tuple> books = new ArrayList<>();
            books.add(new Tuple("compiler","http://www.google.com/"));
            books.add(new Tuple("distributed","URL"));
            books.add(new Tuple("algorithm","URL"));
            books.add(new Tuple("managemant","URL"));
            books.add(new Tuple("pythics","URL"));
            books.add(new Tuple("data structure","URL"));
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            
            String url="";
            alg a = new alg();
            String book = is.readUTF();
            for(int i=0 ; i<books.size() ; i++){
                if(book == books.get(i).getName()){
                    url=books.get(i).getUrl();
                }
            }
//            url = a.search(book);
            os.writeUTF(url);

        } catch (IOException ex) {
            System.out.println("Error " + ex.getMessage());
        }
    }
}
