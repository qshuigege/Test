package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("localhost",9111);
		OutputStream out = s.getOutputStream();
		out.write("hello".getBytes());
		out.flush();
		out.close();
		s.close();
	}
}
