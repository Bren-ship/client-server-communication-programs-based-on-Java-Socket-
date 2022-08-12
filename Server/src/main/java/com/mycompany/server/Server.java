
package com.mycompany.server;
import java.net.*;
import java.io.*;//imports everything from the io class.

public class Server {

    public static void main(String[] args){
       // System.out.println("Hello World!");
       try{
           ServerSocket ss=new ServerSocket(6333);  
        Socket s=ss.accept();  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  

        String str="";  
        String str2="";
        while(!str.equals("Bye")){  
        str=din.readUTF();  
        System.out.println("client says: "+str);  
        str2=br.readLine();  
        dout.writeUTF(str2);  
        dout.flush();  
        }  
        din.close();  
        s.close();  
        ss.close(); 
           
       }catch(Exception e){
         System.out.println("Error: "+e.getLocalizedMessage());  

       }
            
    }
}
