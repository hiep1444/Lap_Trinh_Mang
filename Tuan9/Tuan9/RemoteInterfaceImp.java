package Tuan9;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RemoteInterfaceImp extends UnicastRemoteObject 
        implements RemoteInterface{
    //ham khoi tao
    public RemoteInterfaceImp() throws RemoteException{
        super();
    }
    
    //ghi de phuong thuc truu tuong
    @Override
    public String sayHello() throws RemoteException {
        return "Xin chao, toi la Server";
    }
     
}
