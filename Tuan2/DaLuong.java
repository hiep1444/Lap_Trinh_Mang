/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan2;
public class DaLuong{
    public static void main(String[] args){
        Thread th1= new Thread(new DNRunable("Luong 1"));
        th1.start();

        Thread th2= new Thread(new DNRunable("Luong 2"));
        th2.start();
    }
}
 class DNRunable implements Runnable {
    private String threadName;
    
    public DNRunable (String name){
        this.threadName = name;
    }
    @Override
    public void run (){
        System.out.println( "Bat dau thuc hien cong viec trong"+ threadName);
        for(int i=0;i<=5;i++)
        {
            System.out.println(threadName + ";Buoc "+i);
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("Ket thuc cong viec cua "+ threadName);
    }
    
}
