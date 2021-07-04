import java.io.*;
import java.util.*;

public class PlusAndMultiply {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt(), a = readInt(), b = readInt();
			if (a == 1) { System.out.println((n - 1) % b == 0 ? "Yes" : "No"); continue; }
			long cur = 1;
			boolean flag = false;
			while (cur <= n) {
				if ((n - cur) % b == 0) { flag = true; break; }
				cur *= a;
			}
			System.out.println(flag ? "Yes" : "No");
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
