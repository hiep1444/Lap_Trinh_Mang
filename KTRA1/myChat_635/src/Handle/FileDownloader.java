package Handle;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FileDownloader implements Runnable{
    private final String fileId, path;
    private final int port; 
    private final ArrayList<File> files;
    
    public FileDownloader(String path, String fileName, int port, ArrayList<File> files){
        this.fileId = fileName;
        this.path = path;
        this.port = port;
        this.files = files;
    }
    
    @Override
    public void run() {
        try {
            URL url = new URL(String.format("http://127.0.0.1:%d/%s",port, fileId));

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            try(InputStream inputStream = connection.getInputStream(); ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){
                byte[] buffer = new byte[64 * 1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                File file = new File(path);
                FileOutputStream fos = new FileOutputStream(file);
                outputStream.writeTo(fos);
                
                inputStream.close();
                outputStream.close();
                fos.close();
                
                if(this.files != null){
                    files.add(file);
                }
            }
        } catch (IOException e) {
            System.err.println("[FileDownloader] Lỗi " + e.getMessage());
        }
    }

}