/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


/**
 *
 * @author Admin
 */
public class Client {
    public  Client() {
        try {
             Socket s = new Socket("192.168.1.98", 1999);
            OutputStream os = s.getOutputStream();
            InputStream is = s.getInputStream();
            System.out.print("Gui: ");
            int ch = System.in.read();
           os.write(ch);
         
          //  int ch2 = is.read();
            //System.out.println("Nhan: "+(char)ch2);
            
        } 
        catch (IOException ex) {
            System.out.println("Co loi trong nhap xuat: ");
            
        }
        
}
    public static void main(String[] args) {
        Client c = new Client();
      
    }

}
