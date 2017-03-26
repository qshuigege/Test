package recursion;
import java.util.Scanner;
public class CopyOfTestRecursion {
	public static void main(String args[]) {
		int n;// n为第n项
		java.util.Scanner s = new Scanner(System.in);
		System.out.print("请输入菲波拉契数列的第几项(整数)：");
		n = s.nextInt();
		s.close();
		if (n <= 2)
			return;
		int n1 = 1, n2 = 1, sn = 0;
		for (int i = 0; i < n - 2; i++) {
			sn = n1 + n2;
			n1 = n2;
			n2 = sn;
		}
		System.out.println("斐波那契数列第" + n + "项值为：" + sn);
	}
}
