
package com.mycompany.client;
import java.net.*;
import java.io.*;


public class Client {

    public static void main(String[] args)throws Exception {
       // System.out.println("Hello World!");
       Socket s=new Socket("localhost",6333);
       DataInputStream din = new DataInputStream(s.getInputStream());//read the byte array
       DataOutputStream dout = new DataOutputStream(s.getOutputStream());//write the byte array
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));// to read bytes received from the server 
       
       String str = "",str2="";
       while(!str.equals("Bye")){
           str=br.readLine();
           dout.writeUTF(str);
           dout.flush();
           str2=din.readUTF();
           System.out.println("Server says:"+str2);
       }
       
       dout.close();
       s.close();
    }
}
