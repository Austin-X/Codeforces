import java.io.*;
import java.util.*;

public class WhosOpposite {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int a = readInt(), b = readInt(), c = readInt();
			int n = Math.max((b - a) * 2, (a - b) * 2);
			if (n < a || n < b || n < c) System.out.println(-1);
			else {
				if (c > n / 2) System.out.println(c - n / 2);
				else System.out.println(c + n / 2);
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
