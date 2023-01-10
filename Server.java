import java.net.*;
import java.io.*;

public class Server implements Runnable{
    private Socket incoming = null;
    private BufferedReader in = null;
    private PrintWriter out = null;

    public Server(Socket incoming){
        this.incoming = incoming;
    }

    public void run(){
        try{
            in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(incoming.getOutputStream()));

            System.out.println("The Server is up and running!");
            out.println("Hello from the server!");
            out.println("Enter your username and password");
            out.flush();



            in.close();
            out.close();
            incoming.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
