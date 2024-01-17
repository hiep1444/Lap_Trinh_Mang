package Tuan1;

import java.net.InetAddress;

public class ketnoimang {
    public static void main(String[] args) {
        try{
            InetAddress inet=InetAddress.getByName("www.google.com");
            boolean isKN=inet.isReachable(5000);
            if(isKN)
            {
                System.out.print("co ket noi Internet");
            }
            else
                System.out.println("Khong co ket noi Internet");
        } catch (Exception e){
            e.printStackTrace();
            
        }
    }
    
}
