/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author Admin
 */
public class Server {
    public Server(){
        try {
            ServerSocket ss = new ServerSocket(1999);
             System.out.println("Hello 192.168.1.98:1999");
            Socket s = ss.accept();
            System.out.println("co client ket noi");
            OutputStream os = s.getOutputStream();
            InputStream is = s.getInputStream();
            int ch = is.read();  
            System.out.print("Server nhan duoc:  "+(char)ch);
          
           //else if(ch ==2) System.out.print("tow"+(char)ch);
            //System.out.print("Gui: ");
            //int ch2 = System.in.read();
            //os.write(ch);
             
            //else if(ch ==2) System.out.print("tow"+(char)ch);
            //System.out.print("Gui: ");
            //int ch2 = System.in.read();
            //os.write(ch);
            
            
        } catch (IOException ex) {
           
        }
        
    
    }
    public static void main(String[] args) {
        Server sv = new Server();
   
    }
    
}
