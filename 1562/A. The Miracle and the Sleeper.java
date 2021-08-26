import java.io.*;
import java.util.*;

public class TheMiracleAndTheSleeper {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int l = readInt(), r = readInt();
			if (r % 2 == 0) {
				if (l <= r / 2 + 1) System.out.println(r / 2 - 1);
				else System.out.println(r - l);
			} else {
				if (l <= r / 2 + 1) System.out.println(r / 2);
				else System.out.println(r - l);
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
