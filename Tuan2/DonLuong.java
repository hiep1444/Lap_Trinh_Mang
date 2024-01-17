package Tuan2;
public class DonLuong {
    public static void main(String[] args){
        Thread th1 = new Thread (new DNRunable2());
        th1.start();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        th1.interrupt();
        }
    }
class DNRunable2 implements Runnable{ 
    @Override
    public void run(){
        System.out.println("Luong dang chay - Trang thai"
        +Thread.currentThread().getState());
        try{
            Thread.sleep(5000);
        } catch (Exception e){
            System.out.println("Luong bi ngat ngu - Trang thai"
            +Thread.currentThread().getState());
        }
        System.out.println("Luong da ket thuc - Trang thai"
        +Thread.currentThread().getState());
    }
    
}

