package ChatAppUsingEcho;

import java.io.*;
import java.net.*;

public class EchoServer {
    public static void main(String[] args) {
        BufferedReader in = null;
        PrintWriter out = null;
        ServerSocket s = null;
        Socket incoming = null;
        String str = null;

        try{
            s = new ServerSocket(5000);

            while(true){
                incoming = s.accept();
                in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
                out = new PrintWriter(new OutputStreamWriter(incoming.getOutputStream()));

                while (true){
                    str = in.readLine();

                    if(str.equals(null))
                        break;

                    System.out.println(incoming.getInetAddress() + " says " + str);

                    out.println("Echo " + str);
                    out.flush();

                    if(str.trim().equals("BYE"))
                        break;
                }

                incoming.close();
                in.close();
                out.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
