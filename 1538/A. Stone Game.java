import java.io.*;
import java.util.*;

public class StoneGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt(), min = Integer.MAX_VALUE, max = 0, minIdx = -1, maxIdx = -1;
			for (int i = 1; i <= n; i ++) {
				int x = readInt();
				if (x < min) { min = x; minIdx = i; }
				if (x > max) { max = x; maxIdx = i; }
			}
			if (minIdx > maxIdx) { 
				int temp = minIdx;
				minIdx = maxIdx;
				maxIdx = temp;
			}
			int val1 = minIdx + n - maxIdx + 1, val2 = maxIdx, val3 = n - minIdx + 1;
			pw.println(Math.min(val1, Math.min(val2, val3)));
		}
		pw.close();
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
