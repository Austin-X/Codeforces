import java.io.*;
import java.util.*;

public class SifidAndStrangeSubsequences {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			Arrays.sort(a);
			int ans = 0, diff = Integer.MAX_VALUE;
			for (int i = 0; i < n; i ++) {
				if (a[i] <= 0) {
					ans ++;
					if (i > 0) diff = Math.min(diff, a[i] - a[i - 1]);
				} else if (a[i] > 0 && a[i] <= diff) { ans ++; break; }
			}
			
			System.out.println(Math.max(ans, 1));
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
