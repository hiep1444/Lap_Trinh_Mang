/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;
import java.io.*;

public class T4ReadDataVD2 {
    public static void main(String[] args) {
        try{
            URL url=new URL ("https://www.google.com");
            URLConnection urlconnection = url.openConnection();
            
            BufferedReader reader = new BufferedReader(
            new InputStreamReader(urlconnection.getInputStream()));
            
            FileWriter filewriter =new FileWriter("output.html");
            
            String line;
             while ((line=reader.readLine())!=null){
                 filewriter.write(line+ "\n");
             }
             reader.close();
             filewriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
