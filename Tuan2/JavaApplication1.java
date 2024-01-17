/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tuan2;

/**
 *
 * @author COMPUTER
 */
public class JavaApplication1{
    public static void main(String[] args){
         int[] array = {1,2,3,4,5,6,7,8,9,10};
                int numThreads = 2 ;
                Thread[] ths= new Thread[numThreads]; 
                SumCaculator[] cals = new SumCaculator[numThreads];
                for(int i=0;i<numThreads; i++)
                {
                    cals[i]=new SumCaculator(array, i, numThreads);
                    ths[i] = new Thread(cals[i]);
                    ths[i].start();
                }
                for(int i=0;i<numThreads;i++)
                {
                    try{
                        ths[i].join();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                }  
                int totalSum = 0;
                for(SumCaculator c: cals)
                {
                    totalSum += c.getTong1phan();
                }
                System.out.println("Tong la :"+totalSum);
    }
}
class SumCaculator implements Runnable {
    private int[] array;
    private int startiIndex;
    private int chia;
    private int tong1phan;

    public SumCaculator(int[] array, int startiIndex, int chia) {
        this.array = array;
        this.startiIndex = startiIndex;
        this.chia = chia;
        this.tong1phan = 0;
    }
    
    @Override
    public void run(){
        for(int i=startiIndex; i<array.length;i+=chia)
        {
            tong1phan += array[i];
        }
    }
    public int getTong1phan()
    {
        return tong1phan;
    }
}
