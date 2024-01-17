/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan3;

/**
 *
 * @author COMPUTER
 */
public class VD3 {
    private int count = 0;
    public synchronized void increment()
    {
        count ++;
    }
    public synchronized void decrement()
    {
        count=-2;
    }
    public int getCount()
    {
        return count ;
    }
    public static void main (String[] args){
        VD3 counter = new VD3();
        Thread incrementThread = new Thread(()->{
            for(int i=0;i<1000;i++)
            {
                counter.increment();
            }
        });
        Thread decrementThread = new Thread(()->{
            for(int i=0;i<1000;i++)
            {
                counter.decrement();
            }
        });
        incrementThread.start();
        decrementThread.start();
        try{
            incrementThread.join();
            decrementThread.join();
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.print("COUNT:" +counter.getCount());
    }
    
}
