import java.io.*;
import java.util.*;

public class InfinityTable {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int k = readInt();
			int n = (int)Math.ceil(Math.sqrt(k)), cur = (n - 1) * (n - 1) + 1;
			int r = 1, c = n;
			for (int i = 1; i < n; i ++) {
				if (cur == k) break;
				r ++;
				cur ++;
			}
			if (cur == k) { System.out.println(r + " " + c); continue; }
			for (int i = n; i > 1; i --) {
				if (cur == k) break;
				c --;
				cur ++;
			}
			System.out.println(r + " " + c);
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
