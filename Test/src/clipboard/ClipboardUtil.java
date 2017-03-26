package clipboard;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;

public class ClipboardUtil {

	// 获取剪切板中的内容
	public String getClipboardText(Clipboard clipboard) throws Exception {
		Transferable contents = clipboard.getContents(null);
		if (contents != null) {
			// 检查内容是否为文本类型
			if (contents.isDataFlavorSupported(DataFlavor.stringFlavor)) {
				return (String) contents
						.getTransferData(DataFlavor.stringFlavor);
			}
		}
		return null;
	}

	// 往剪切板写文本数据
	public void setClipboardText(Clipboard clipboard, String text) {
		Transferable contents = new StringSelection(text);
		clipboard.setContents(contents, null);
	}

	// 从剪切板读取图像
	public Image getImageFromClipboard(Clipboard clipboard) throws Exception {
		Transferable contents = clipboard.getContents(null);
		if (contents == null) {
			return null;
		} else if (contents.isDataFlavorSupported(DataFlavor.imageFlavor)) {
			return (Image) contents.getTransferData(DataFlavor.imageFlavor);
		}
		return null;
	}

	public void setImageToClipboard() {

	}

	public void setClipboardImage2(final Image image) {
		Transferable trans = new Transferable() {
			public DataFlavor[] getTransferDataFlavors() {
				return new DataFlavor[] { DataFlavor.imageFlavor };
			}

			public boolean isDataFlavorSupported(DataFlavor flavor) {
				return DataFlavor.imageFlavor.equals(flavor);
			}

			public Object getTransferData(DataFlavor flavor)
					throws UnsupportedFlavorException {
				if (isDataFlavorSupported(flavor))
					return image;
				throw new UnsupportedFlavorException(flavor);
			}

		};
		Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(trans, null);
	}
}
