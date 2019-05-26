/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Naming;
import java.rmi.registry.Registry;

/**
 *
 * @author ALKODS
 */
public class HelloServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            Registry r = java.rmi.registry.LocateRegistry.createRegistry(1099);
            r.rebind("Hello", new Hello("Distributed System"));
            System.out.println("Server connectedand ready to operation.");
            
        }catch(Exception e){
            System.out.println("Server not connected: "+e);
        }
        
    }
    
}
