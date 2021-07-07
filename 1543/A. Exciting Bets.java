import java.io.*;
import java.util.*;

public class ExcitingBets {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			long a = readLong(), b = readLong();
			long min = Math.min(a, b), max = Math.max(a, b);
			if (max == min) System.out.println("0 0");
			else {
				long diff = max - min;
				System.out.print(diff + " ");
				long rem = min % diff;
				System.out.println(Math.min(rem, diff - rem));
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
