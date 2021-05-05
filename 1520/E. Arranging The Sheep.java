import java.io.*;
import java.util.*;

public class ArrangingTheSheep {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			long[] forwardPfs = new long[n + 2], backwardPfs = new long[n + 2];
			char[] ch = readLine().toCharArray();
			int cnt = 0;
			for (int i = 1; i <= n; i ++) {
				if (ch[i - 1] == '*') { forwardPfs[i] = forwardPfs[i - 1]; cnt ++; }
				else forwardPfs[i] = forwardPfs[i - 1] + cnt;
			}
			
			cnt = 0;
			for (int i = n; i >= 1; i --) {
				if (ch[i - 1] == '*') { backwardPfs[i] = backwardPfs[i + 1]; cnt ++; }
				else backwardPfs[i] = backwardPfs[i + 1] + cnt;
			}
			
			long ans = Long.MAX_VALUE;
			for (int i = 1; i <= n; i ++) ans = Math.min(ans, Math.min(forwardPfs[i] + backwardPfs[i + 1], forwardPfs[i - 1] + backwardPfs[i]));
			
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
