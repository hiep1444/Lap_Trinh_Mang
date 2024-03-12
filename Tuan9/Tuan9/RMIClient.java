package Tuan9;

import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {
            //tim doi tuong tu may chu
            RemoteInterface object=(RemoteInterface)
                    Naming.lookup("//localhost:1099/RemoteObject");
            //trieu goi tu xa
            System.out.println(object.sayHello());
        } catch (Exception e) {
            System.err.println("Loi: "+e.toString());
            e.printStackTrace();
        }
    }
}
