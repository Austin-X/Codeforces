import java.io.*;
import java.util.*;

public class PleasantPairs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			int[] a = new int[n + 1];
			for (int i = 1; i <= n; i ++) a[i] = readInt();
			long ans = 0;
			for (int i = 1; i <= n; i ++) {
				int start;
				if (a[i] > i + i - 1) continue;
				else if (a[i] >= i) start = a[i] - i;
				else start = a[i] - i % a[i];
				for (int j = start; j < i; j += a[i]) if (a[i] * a[j] == i + j) ans ++;
			}
			System.out.println(ans);
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
