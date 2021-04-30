import java.io.*;
import java.util.*;

public class MaximumSumOfProducts {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		int[] a = new int[n + 1], b = new int[n + 1];
		for (int i = 1; i <= n; i ++) a[i] = readInt();
		for (int i = 1; i <= n; i ++) b[i] = readInt();
		long[] pfs = new long[n + 1];
		for (int i = 1; i <= n; i ++) pfs[i] = pfs[i - 1] + (long)a[i] * b[i];
		
		long[][] dp = new long[n + 1][n + 1];
		
		long best = 0;
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= n - i + 1; j ++) {
				if (i == 1) {
					dp[i][j] = (long)a[j] * b[j];
					best = Math.max(best, pfs[j - 1] + dp[i][j] + pfs[n] - pfs[j]);
				} else {
					dp[i][j] = (long)a[j + i - 1] * b[j] + (long)a[j] * b[j + i - 1] + dp[i - 2][j + 1];
					best = Math.max(best, pfs[j - 1] + dp[i][j] + pfs[n] - pfs[j + i - 1]);
				}
			}
		}
		
		System.out.println(best);
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
