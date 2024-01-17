package Tuan3;

public class VD5 {
    private final Object monitor = new Object();
    public void waitForSignal() throws InterruptedException
    {
        synchronized (monitor)
        {
            monitor.wait();
        }
    }
    public void notifySignal()
    {
        synchronized (monitor) 
        {
            monitor.notify();
        }
    }
}
