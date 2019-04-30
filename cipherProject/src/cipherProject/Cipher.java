package cipherProject;

public class Cipher {
	private int myKey;
	private char codedAlphabet[];

	public Cipher(int key) {
		codedAlphabet = "abcdefghijklmnopqrstuvwxyz.,:;!£$%&/()=?^אטלעש-_".toCharArray();
		this.myKey = key;
	}

	// metodo Encode per criptare il messaggio
	public String Encode(String plainText) {

		String codedText;
		String codedString;

		codedText = "";

		for (int j = 0; j < plainText.length(); j++) {
			codedString = Character.toString(change(plainText.charAt(j), myKey));

			codedText += codedString;
		}
		return codedText;
	}

	// metodo change usato da Encode per sostituire i caratteri.
	private char change(char token, int key) {

		char shiftedToken;
		shiftedToken = ' ';

		for (int i = 0; i < codedAlphabet.length; i++) {
			if (codedAlphabet[i] == token) {

				shiftedToken = codedAlphabet[(i + key) % codedAlphabet.length];

				break;
			}

		}

		return shiftedToken;

	}
}
