import java.io.*;
import java.util.*;

public class PalindromeGameEasyVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			@SuppressWarnings("unused")
			int n = readInt();
			char[] ch = readLine().toCharArray();
			int zeroCnt = 0;
			for (char c: ch) if (c == '0') zeroCnt ++;
			
			if (zeroCnt % 2 == 0 || zeroCnt == 1) System.out.println("BOB");
			else System.out.println("ALICE");
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
