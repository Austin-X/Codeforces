import java.io.*;
import java.util.*;

public class UpTheStrip {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();

		int[] dp = new int[n + 1], fSum = new int[n + 1]; dp[1] = 1;
		int sum = 0;
		for (int i = 1; i <= n; i ++) {
			dp[i] = (dp[i] + sum) % m;
			fSum[i] = (fSum[i] + fSum[i - 1]) % m;
			dp[i] = (dp[i] + fSum[i - 1]) % m;
			
			for (int j = i + i; j <= n; j += i) {
				fSum[j] = ((fSum[j] + dp[i] - dp[i - 1]) % m + m) % m;
				dp[j] = ((dp[j] + dp[i] - dp[i - 1]) % m + m) % m;
			}
 
			sum += dp[i];
			sum %= m;
		}

		System.out.println(dp[n]);
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
