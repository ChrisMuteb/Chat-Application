import java.net.*;
import java.io.*;

public class Client {
    public static void main(String[] args) {
        try{
            String host = args.length > 0 ? args[0] : "localhost";
            Socket socket = new Socket(host, 8009);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            while(true){
                String line = in.readLine();
                if(line.equals(null))
                    break;

                System.out.println(line);
            }
            in.close();
            out.close();
            socket.close();
        }catch(Exception e){}
    }
}
