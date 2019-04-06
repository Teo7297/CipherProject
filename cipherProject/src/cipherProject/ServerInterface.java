package cipherProject;

import java.io.IOException;

public interface ServerInterface {
	public static final int PORT = 9090;
	
	public String CeasarCode(int key, String PlainText) throws IOException; 
	public void close() throws IOException;															//importante avere un metodo di close()
	
}
