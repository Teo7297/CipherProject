package cipherProject;

import java.io.*;
import java.net.*;
import java.util.StringTokenizer;

public class ServerSkeleton implements Runnable{
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	private Server server = new Server();
	
	String input;
	String plainText;
	String codedText = "";
	
	public ServerSkeleton(Socket sock) {
		this.socket = sock;
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
			
		}catch(IOException e) {
			System.err.println("errore socket skeleton");
		}
	}
	
	
	
	public void run() {
		while(!socket.isClosed()) {
			try {
				while ((input = in.readLine()) != null) {
					// ceasar encoding method
					if (input.startsWith("<ceasar>")) {
						StringTokenizer st = new StringTokenizer(input);

						String command = st.nextToken();
						int key = Integer.parseInt(st.nextToken());
						Cipher cipher = new Cipher(key);

						plainText = st.nextToken();
						codedText += cipher.Encode(plainText);
						while (st.hasMoreTokens()) {
							plainText = st.nextToken();
							codedText += " "+ cipher.Encode(plainText);
						}
						out.println(codedText);
					}
					//implement more encoding methods
				}
			
			
			
			in.close();
			out.close();
			socket.close();
			}catch(IOException | NumberFormatException e) {
				System.err.println("ioexc or numberformat check skeleeton run");
			}
		}
	}
}