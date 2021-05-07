import java.io.*;
import java.util.*;

public class NastiaAndNearlyGoodNumbers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			long a = readLong(), b = readLong();
			if (b > 2) {
				System.out.println("YES");
				System.out.println(a + " " + (a * b - a) + " " + (a * b));
			} else if (b == 2) {
				System.out.println("YES");
				System.out.println(a + " " + (a * b + a) + " " + (2 * a * b));
			} else System.out.println("NO");
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
