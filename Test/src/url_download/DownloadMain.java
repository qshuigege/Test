package url_download;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadMain {
	public static void main(String[] args) {
		// URL url = null;
		try {
			URL url = new URL("https://www.baidu.com/img/bd_logo1.png");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");
			conn.setRequestProperty("Charset","UTF-8");
			conn.connect();
			int file_leng = conn.getContentLength();
			System.out.println("file length---->"+file_leng);
			BufferedInputStream bin = new BufferedInputStream(conn.getInputStream());
			
			OutputStream out = new FileOutputStream(new File("D:\\baidu_logo.png"));
			int size = 0;//实际读到的内容
			byte[] buf = new byte[1024];//把每次读到的内容放到buf中，最多读1KB
			while ((size = bin.read(buf)) != -1) {
				out.write(buf, 0, size);
			}
			bin.close();
			out.close();
			
			System.exit(0);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
