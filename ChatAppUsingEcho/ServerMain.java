package ChatAppUsingEcho;

import java.net.*;

public class ServerMain {
    public static void main(String[] args){
        ServerSocket s = null;

        try{
            s = new ServerSocket(8009);

            Socket incoming = s.accept();
            new Thread(new Server(incoming)).start();
        }catch(Exception e){
            e.printStackTrace();
        }

        try{
            s.close();
        }catch(Exception e){}
    }
}
