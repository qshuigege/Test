package recursion;
import java.util.Scanner;
public class TestRecursion {
	public static void main(String args[]) {
		int n, fn;// n为第n项，fn为第n项的值
		java.util.Scanner s = new Scanner(System.in);
		System.out.print("请输入菲波拉契数列的第几项(整数)：");
		n = s.nextInt();
		s.close();
		fn = function(n);
		System.out.println("斐波那契数列第" + n + "项为：" + fn);
	}
	public static int function(int n) {
		if (n == 1 || n == 2)
			return 1;
		return function(n - 1) + function(n - 2);
	}
}
