package ChatAppUsingEcho;

import java.net.*;
import java.io.*;
import java.util.*;

public class EchoClient {
    public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String sms = null;
		try {
			String host = args.length > 0 ? args[0] : "localhost";
			
			Socket socket = new Socket(host, 5000);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//send data to the server
			while(true) {
				System.out.println("Send YOUR msm: ");
				sms = sc.nextLine();
				out.println("line -> " + sms);
				out.flush();
				
				String str = in.readLine();
				System.out.println(str);
				
				if(str == null)
					break;
				
				if(sms.trim().equals("BYE")) {
					System.out.println("\nsms is " + sms);
					break;
				}
			}
			
			in.close();
			out.close();
			socket.close();
			System.out.println("\nClose connection");
		}catch(Exception e) {}
	}

}
