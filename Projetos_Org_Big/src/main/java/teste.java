
import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ti
 */
public class teste {
    public static void main(String[] args) throws UnknownHostException {
        
        //Retorna o nome do computador
        InetAddress addr = InetAddress.getLocalHost();
        String hostname = addr.getHostName();
        System.out.println(hostname);
         //Retorna o nome do computador *********fim***********
               
    }
    
}
