import java.io.*;
import java.util.*;

public class LordOfTheValues {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			
			pw.println(n * 3);
			for (int i = 1; i <= n; i += 2) {
				pw.println("1 " + i + " " + (i + 1));
				pw.println("2 " + i + " " + (i + 1));
				pw.println("1 " + i + " " + (i + 1));
				pw.println("2 " + i + " " + (i + 1));
				pw.println("1 " + i + " " + (i + 1));
				pw.println("2 " + i + " " + (i + 1));
			}
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
