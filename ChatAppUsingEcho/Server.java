package ChatAppUsingEcho;

import java.net.*;
import java.io.*;

public class Server implements Runnable{
    private Socket incoming = null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private String username = null;
    private String password = null;
    public String str = null;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Server(Socket incoming){
        this.incoming = incoming;
    }

    public void run(){
        try{
            in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(incoming.getOutputStream()));

//            System.out.println("The Server is up and running!");
//            out.println("Hello from the server!");
//            out.println("Enter your username : ");
//            out.flush();
//            String uName = in.readLine();
//            setUsername(uName);
//            out.flush();
//            out.println("Enter your password : ");
//            String pass = in.readLine();
//            setPassword(pass);
//            out.flush();

//            out.println(getUsername() + " " + getPassword());

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


            in.close();
            out.close();
            incoming.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

