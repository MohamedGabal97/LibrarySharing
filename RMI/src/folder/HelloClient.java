/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder;

import java.rmi.Naming;
import rmi.HelloInterface;

/**
 *
 * @author ALKODS
 */
public class HelloClient {
    public static void main(String []argv){
        try{
            HelloInterface h = (HelloInterface)Naming.lookup("//localhoast/Hello");
            System.out.println(h.say());
        }catch(Exception e){
            System.out.println("HelloClient Exception: "+e);
        }
    }
}
