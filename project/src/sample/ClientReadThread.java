package sample;

import java.io.IOException;

public class ClientReadThread implements Runnable{
Thread t;
private NetworkUtil networkUtil;
ClientReadThread(NetworkUtil networkUtil)
{
    this.networkUtil=networkUtil;
    t=new Thread(this);
    t.start();
}
    @Override
    public void run() {
        System.out.println("client read thread waiting to read");
        try {
            Object o=networkUtil.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
