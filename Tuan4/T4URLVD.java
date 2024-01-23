/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan4;
import java.net.*;
public class T4URLVD {
    public static void main(String[] args) {
        try{
            URL url=new URL("https://www.youtube.com/watch?v=tiLsOxyRMg0");
            System.out.println("Protocol: "+url.getProtocol());
            System.out.println("Host: "+url.getHost());
            System.out.println("Port: "+url.getPort());
            System.out.println("Path: "+url.getPath());
            System.out.println("truy van: "+url.getQuery());
            System.out.println("tham chieu: "+url.getRef());

        } catch (Exception e){
        }
    }
}
