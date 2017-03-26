package socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("准备接收客户端信息：");
		ServerSocket server = new ServerSocket(9111);

		//Socket s = null;
		while (true) {
			Socket s = server.accept();
			InputStream in = s.getInputStream();
			byte[] buf = new byte[1024];
			int num = in.read(buf);
			String str = new String(buf,0,num);
			System.out.println(s.getInetAddress()+str);
			Thread.sleep(10000);
			System.out.println("hello");
		

		}
//		s.close();
//		server.close();
	}
}
