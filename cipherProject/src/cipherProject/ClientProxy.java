package cipherProject;

import java.io.*;
import java.net.*;

public class ClientProxy implements ServerInterface{
	Socket socket;
	BufferedReader in;
	PrintWriter out;
	
	public ClientProxy() {

		try {
			socket = new Socket(InetAddress.getLocalHost(), ServerInterface.PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//metodi interfaccia
	}
	public String CeasarCode(int key, String plainText) throws IOException {
		out.println("<ceasar> "+ key +" "+plainText);
		String codedText = in.readLine();
		return codedText;
		
		
	}
	public void close() throws IOException {
		socket.close();
	}
	
}
