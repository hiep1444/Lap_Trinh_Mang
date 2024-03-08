package tuan8;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8888);
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Student std = (Student)ois.readObject();
            System.out.println("Receive : " + std.toString());
        } catch (Exception e) {
        }
    }
}
