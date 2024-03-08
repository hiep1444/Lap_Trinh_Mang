package tuan8;
import java.io.*;
import java.net.*;

public class UDPExample {
    public static void main(String[] args) {
        try {
            new Thread(()->{
                try {
                    DatagramSocket socket = new DatagramSocket(12345);
                    //Nhan du lieu qua UDP
                    byte[] receive = new byte[1024];
                    DatagramPacket receivePacket = new DatagramPacket(receive, receive.length);
                    socket.receive(receivePacket);
                    //Chuyen mang byte thanh doi tuong
                    ByteArrayInputStream bis = new ByteArrayInputStream(receivePacket.getData());
                    ObjectInputStream ois = new ObjectInputStream(bis);
                    Student student = (Student)ois.readObject();
                    System.out.println("Receive : " + student.toString());
                } catch (Exception e) {
                }
            }).start();
            Student std = new Student("Nguyen Van A", 25);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(std);
            byte[] data = bos.toByteArray();
            System.out.println(data.length);
            //Gui du lieu qua UDP
            InetAddress address = InetAddress.getByName("localhost");
            try (DatagramSocket socket = new DatagramSocket()) {
                DatagramPacket packet = new DatagramPacket(data, data.length,address, 12345);
                socket.send(packet);
                System.out.println("Du lieu da duoc gui");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
    }
}
