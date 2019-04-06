package cipherProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Client {
	public static void main(String[] args) throws IOException {

		ServerInterface server = null;
		String plainText = "";
		String codedText;
		int key = 0;
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			server = new ClientProxy();

			System.out.println("inserire testo da cifrare: ");
			plainText = br.readLine();
			System.out.println("inserire chiave di cifratura (numero da 1 a 25): ");

			key = Integer.parseInt(br.readLine());

		} catch (IOException | NumberFormatException e) {
			System.err.println("testo o chiave non valido");
		}
		codedText = server.CeasarCode(key, plainText);
		server.close();
		System.out.println(codedText);

	}
}
