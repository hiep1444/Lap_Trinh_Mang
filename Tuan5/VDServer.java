package tuan5;

import java.net.*;
import java.io.*;

class ClientHandler implements Runnable{
    private Socket clientSocket;
    public ClientHandler(Socket socket){
        this.clientSocket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(this.clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(this.clientSocket.getOutputStream(), true);
            String clientMessage;
            while((clientMessage = in.readLine()) != null){
                System.out.println("Client gui : " + clientMessage);
                out.println(clientMessage);
            }

        } catch (Exception e) {
            try {
                this.clientSocket.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
}
public class VDServer {
    
    public static void main(String[] args) {
        final int port = 12345;
        try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Server socket dang cho ket noi tu client ... ");
            while(true){
                Socket socket = ss.accept();
                System.out.println("Client da ket noi "+socket);
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}