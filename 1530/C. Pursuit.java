import java.io.*;
import java.util.*;

public class Pursuit {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt(), k = n - n / 4;
		    int[] a = new int[101], b = new int[101];
			for (int i = 0; i < n; i ++) a[readInt()] ++;
			for (int i = 0; i < n; i ++) b[readInt()] ++;

			int sumA = calc(k, a), sumB = calc(k, b), ans = 0;
			while (sumA < sumB) {
				a[100] ++;
				b[0] ++;
				n ++;
				k = n - n / 4;
				sumA = calc(k, a); sumB = calc(k, b);
				ans ++;
			}
			System.out.println(ans);
		}
	}

	static int calc (int k, int[] a) {
		int sum = 0, cnt = 0;
		for (int i = 100; i >= 0; i --) {
			if (cnt + a[i] >= k) {
				sum += (k - cnt) * i;
				break;
			} else {
				sum += a[i] * i;
				cnt += a[i];
			}
		}
		return sum;
	}
	
	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens()) 
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong() throws IOException {
		return Long.parseLong(next());
	}
	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter() throws IOException {
		return next().charAt(0);
	}
	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
