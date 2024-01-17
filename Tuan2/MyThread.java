/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Tuan2;

/**
 *
 * @author COMPUTER
 */
public class MyThread extends Thread {
    @Override
    public void run (){
        System.out.println("Ham dang chay");
    }
    public static void main(String[] args){
        MyThread th= new MyThread();
        th.start();
    }

}
