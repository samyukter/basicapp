import java.net.*;
import java.io.*;
import java.util.*;
class Serverprocipher{
    public static void main(String args[])throws Exception{   
        ServerSocket ss=new ServerSocket(1234);
        Socket s=ss.accept();
        InputStream in=s.getInputStream();
        
        while(true){
         byte b[]=new byte[100];
        in.read(b);
        int key=5;
        
        String str=new String(b);
        String y="";
        System.out.println("received"+str);
        for(int i=0;i<str.length();i++){
            int x=(int)str.charAt(i)-key;
            y=y+(char)x;
        }
        System.out.println("deciphered:"+y);
        }
    }
}