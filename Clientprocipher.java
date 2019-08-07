import java.net.*;
import java.io.*;
import java.util.*;
class Clientprocipher{
public static void main(String args[]) throws Exception{
	Socket s=new Socket(InetAddress.getLocalHost(),1234);
    Scanner sc=new Scanner(System.in);
    DataInputStream in=new DataInputStream(System.in);
    OutputStream out=s.getOutputStream();
    int key=5;
    while(true){
    String str=sc.next();
    System.out.println(str);
    String y="";
    for(int i=0;i<str.length();i++){
       int x= (int)str.charAt(i)+key;
       char c=(char)x;
       y=y+c;
    }
    System.out.println("snt.."+y);
    out.write(y.getBytes());   
    }
}
}