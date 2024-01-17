/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan1;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 *
 * @author COMPUTER
 */
public class DisplayAllIP {
    public static void main(String[] args) {
        try{
                Enumeration<NetworkInterface>netInterface
                    = NetworkInterface.getNetworkInterfaces();

                while(netInterface.hasMoreElements())
                {
                    NetworkInterface networkInterface
                            =netInterface.nextElement();
                    Enumeration<InetAddress> inetAdress
                            =networkInterface.getInetAddresses();
                    while(inetAdress.hasMoreElements())
                    {
                        InetAddress address
                                =inetAdress.nextElement();
                        System.out.println("Interface:"
                                +networkInterface.getName()
                                +"; Dia chia IP:" + address.getHostAddress());
                    }    

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
