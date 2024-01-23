/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan4;
import java.net.*;
/**
 *
 * @author COMPUTER
 */
public class VD {
    public static void main(String[] args) {
        try{
            InetAddress addByName=InetAddress.getByName("www.google.com");
            InetAddress addByIP=InetAddress.getByName("192.168.11.224");
            System.out.println("Address By Name:" +addByName);
            System.out.println("Address By IP:" +addByIP);
            
            InetAddress addByName1=
                    InetAddress.getByName("www.vnexpress.net");
            String hostname=addByName.getHostName();
            System.out.println("Host Name: "+hostname);
            
            String ip =addByName1.getHostAddress();
            System.out.println("Dia chi IP: "+ip);

            InetAddress addByName2=
                    InetAddress.getByName("www.vnexpress.net");
            boolean isIP4= addByName2 instanceof java.net.Inet4Address;
            System.out.println("Co phai IP4 khong :"+isIP4);
            
            boolean isIP6 = addByName2 instanceof java.net.Inet6Address;
            System.out.println("Co phai IP6 khong :"+isIP6);

        }catch (Exception e){
    }
}
}
