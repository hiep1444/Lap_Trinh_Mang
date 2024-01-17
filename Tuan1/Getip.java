/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan1;

import java.net.InetAddress;

/**
 *
 * @author COMPUTER
 */
public class Getip {
    public static void main(String[] args) {
        try{
            InetAddress inet=InetAddress.getByName("www.google.com");
            System.out.println("Dia chi cua trang web google.com"+
                    inet.getHostAddress());
        } catch (Exception e){ 
            e.printStackTrace();
        }
    }
}
