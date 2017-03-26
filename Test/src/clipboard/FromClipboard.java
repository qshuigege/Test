package clipboard;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class FromClipboard {
	public static void main(String[] args) {
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
		/*Transferable contents = new StringSelection("HelloWorld");
		cb.setContents(contents, null);
		System.out.println("aaa");*/
		
		ClipboardUtil util = new ClipboardUtil();
		try {
			String str = util.getClipboardText(cb);
//			System.out.println("系统剪切板中的内容：\n"+str);
			String[] arr = str.split("\n");
			System.out.println("数组长度："+arr.length);
			for (int i = 0; i < arr.length; i++) {
				System.out.println(arr[i] + i);
			}
			System.out.println("===================================");
			String arr0 = arr[0];
			String[] arr0Arr = arr0.split("\t");
			for (int i = 0; i < arr0Arr.length; i++) {
				System.out.println(arr0Arr[i]+i);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
