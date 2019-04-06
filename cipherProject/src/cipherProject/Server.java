package cipherProject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {

	public static final int PORT = 9090;

	public static void main(String[] args) throws NumberFormatException, IOException {
		String codedText;
		String plainText;
		String input;
		BufferedReader in;
		PrintWriter out;
		ServerSocket servSocket = new ServerSocket(PORT);
		Socket socket;

		try {
			while (true) {
				socket = servSocket.accept();
				try {
					in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

					while ((input = in.readLine()) != null) {
						// ceasar encoding method
						if (input.startsWith("<ceasar>")) {
							StringTokenizer st = new StringTokenizer(input);

							String command = st.nextToken();
							int key = Integer.parseInt(st.nextToken());
							plainText = st.nextToken();

							Cipher cipher = new Cipher(key);
							codedText = cipher.Encode(plainText);
							out.println(codedText);
						}
					}
					in.close();
					out.close();
				} finally {
					socket.close();
				}
			}
		} finally {
			servSocket.close();
		}
	}

}
