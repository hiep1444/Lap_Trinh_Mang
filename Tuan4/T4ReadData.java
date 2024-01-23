/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan4;

import java.io.*;
import java.net.*;

public class T4ReadData {
     public static void main(String[] args) {
         try{
             URL url=new URL ("https://www.google.com");
             URLConnection urlconnection = url.openConnection();
             
             BufferedReader reader = new BufferedReader(
             new InputStreamReader(urlconnection.getInputStream()));
             
             String line;
             while ((line=reader.readLine())!=null){
                 System.out.println(line);
             }
             reader.close();
         }catch (Exception e ){
         e.printStackTrace();
         
     }
    }
}
