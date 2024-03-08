package tuan8;
import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("Server is running ...");
            while(true){
                Socket socket = ss.accept();
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Student student = new Student("Tran Van B", 21);
                oos.writeObject(student);
                oos.close();
                socket.close();
            }
        } catch (Exception e) {
        }
        
    }
}
