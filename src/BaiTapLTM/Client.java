/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaiTapLTM;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Client {
    private final InetAddress host;
    private final int port;
    public Client(InetAddress host, int port){
    super();
    this.host = host;
    this.port = port;
    }
    private void excute () throws IOException{
    Socket client = new Socket(host, port);
    ReadClient read = new ReadClient(client);
    read.start();
    WriteClient write = new WriteClient(client);
    write.start();
    }
    public static void main(String[] args) throws IOException {
        Client c = new Client(InetAddress.getLocalHost(), 15797);
        c.excute();
    }
    
}
class ReadClient extends Thread{
private final Socket client;
 
public ReadClient(Socket client){
this.client = client;
}

    @Override
    public void run() {
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(client.getInputStream());
            while (true) {
                String sms = dis.readUTF();
                if(sms.equalsIgnoreCase("1")){
                    System.out.println("one");
                
                }
                else if(sms.equalsIgnoreCase("2")){
                    System.out.println("tow");
                
                }
                else if(sms.equalsIgnoreCase("3")){
                    System.out.println("three");
                
                }
                else if(sms.equalsIgnoreCase("4")){
                    System.out.println("four");
                
                }
                else if(sms.equalsIgnoreCase("5")){
                    System.out.println("five");
                
                }
                else if(sms.equalsIgnoreCase("6")){
                    System.out.println("Six");
                
                }
                else if(sms.equalsIgnoreCase("7")){
                    System.out.println("Seven");
                
                }
                 else if(sms.equalsIgnoreCase("8")){
                    System.out.println("eight");
                
                }
                  else if(sms.equalsIgnoreCase("9")){
                    System.out.println("Nine");
                
                }
                    else if(sms.equalsIgnoreCase("end")){
                    System.out.println("good bye");
                    client.close();
                
                }
                else System.out.println(sms);
               
                
            }
        } catch (Exception e) {
            try {
                dis.close();
                client.close();
            } catch (IOException ex) {
                System.out.println("Ngắt kết nối Server");
            }
          
            
        }
    }
}
class WriteClient extends Thread{
private final  Socket client;

public WriteClient (Socket client)
{
this.client = client;
}

    @Override
    public void run() {
        DataOutputStream dos = null;
        Scanner sc = null;
        try {
            dos =new DataOutputStream(client.getOutputStream());
            sc = new Scanner(System.in);
            while (true) {                
                String sms = sc.nextLine();
                dos.writeUTF(sms);
            }
        } catch (Exception e) {
            try {
                dos.close();
                client.close();
            } catch (IOException ex) {
                System.out.println("Ngắt kết nối Server");
            }
    }


}
}

