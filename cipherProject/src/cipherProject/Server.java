package cipherProject;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class Server {

	public static void main(String[] args) throws NumberFormatException, IOException {

		ServerSocket servSocket = new ServerSocket(ServerInterface.PORT);
		Socket socket;

		try {
			while (true) {
				System.out.println("waiting for client..");
				socket = servSocket.accept();
				System.out.println("client connected! ");

				new Thread(new ServerSkeleton(socket)).start();
				System.out.println("a new Thread is serving client connected to: "+ socket);

			}
		} finally {
			servSocket.close();
		}
	}

}
