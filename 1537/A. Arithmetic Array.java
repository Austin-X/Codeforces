import java.io.*;
import java.util.*;

public class ArithmeticArray {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt(), sum = 0;
			for (int i = 0; i < n; i ++) sum += readInt();
			if (sum < n) pw.println(1);
			else pw.println(sum - n);
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
