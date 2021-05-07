import java.io.*;
import java.util.*;

public class NastiaAndAGoodArray {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			int[] a = new int[n + 1];

			int min = Integer.MAX_VALUE, minIdx = -1;
			for (int i = 1; i <= n; i ++) {
				a[i] = readInt();
				if (a[i] < min) { min = a[i]; minIdx = i; }
			}
			System.out.println(n - 1);
			for (int i = minIdx + 1; i <= n; i ++) {
				System.out.println(minIdx + " " + i + " " + min + " " + (a[i - 1] + 1));
				a[i] = a[i - 1] + 1;
			}
			for (int i = minIdx - 1; i >= 1; i --) {
				System.out.println(i + " " + minIdx + " " + (a[i + 1] + 1) + " " + min);
				a[i] = a[i + 1] + 1;
			}
		}
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
