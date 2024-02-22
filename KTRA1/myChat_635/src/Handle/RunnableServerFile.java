package Handle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class RunnableServerFile implements Runnable{
    private File fileTarget; 
    private final boolean isAcceptOne;
    private final int portConnect;
    private final ArrayList<File> files;
    
    public RunnableServerFile(File fileTarget, boolean isAcceptOne, int port, ArrayList<File> files) {
        this.fileTarget = fileTarget;
        this.isAcceptOne = isAcceptOne;
        this.portConnect = port;
        this.files = files;
    }
    
    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(portConnect); 
            while(true){
                Socket clientSocket = serverSocket.accept(); 
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String request = in.readLine();

                if (request.contains("GET")) {
                    //example : "GET /image.png HTTP/1.1
                    System.out.println(request);
                    if(!isAcceptOne){
                        String fileRequired = request.split("\\ ")[1].replaceAll("\\/", "");
                        for(File f : files){
                            if(f.getName().strip().equals(fileRequired.strip())){
                                fileTarget = f;
                                break;
                            }
                        }
                    }
                    //example : "GET / HTTP/1.1"
                    out.println("HTTP/1.1 200 OK");
                    out.println("Content-Type: " + Files.probeContentType(fileTarget.toPath()));
                    out.println();

                    try(FileInputStream fileInputStream = new FileInputStream(fileTarget)){
                        byte[] buffer = new byte[64 * 1024];
                        int bytesRead;
                        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                            clientSocket.getOutputStream().write(buffer, 0, bytesRead);
                        }
                        fileInputStream.close();
                    }
                } else {
                    out.println("HTTP/1.1 404 Not Found");
                }

                clientSocket.close();
                serverSocket.close();
                if(isAcceptOne) break;
            }
        } catch (IOException e) {
            System.err.println("Client.[RunnableServerFile] Lỗi " + e.getMessage());
        }
    }
}
