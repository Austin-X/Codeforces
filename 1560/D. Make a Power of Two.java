import java.io.*;
import java.util.*;

public class MakeAPowerOfTwo {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		long[] pows = new long[63]; pows[0] = 1;
		for (int i = 1; i < 63; i ++) pows[i] = pows[i - 1] * 2;
		
		while (t-- > 0) {
			String n = readLine();
			int ans = 10;
			for (int i = 0; i < 63; i ++) {
				String s = String.valueOf(pows[i]);
				int best = 0;
				for (int k = 0; k < n.length(); k ++) {
					int idx = 0;
					for (int l = k; l < n.length(); l ++) {
						if (n.charAt(l) == s.charAt(idx)) idx ++;
						if (idx == s.length()) break;
					}
					best = Math.max(best, idx);
				}
				ans = Math.min(ans, n.length() - best + s.length() - best);
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
