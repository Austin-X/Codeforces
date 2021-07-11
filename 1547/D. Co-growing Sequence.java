import java.io.*;
import java.util.*;

public class CogrowingSequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			int[] x = new int[n], res = new int[n];
			for (int i = 0; i < n; i ++) x[i] = readInt();
			if (n == 1) { System.out.println(0); continue; }
			
			for (int i = 0; i < n - 1; i ++) {
				if ((x[i] & x[i + 1]) == x[i]) continue;
				else {
					res[i + 1] = (x[i] ^ x[i + 1]) & x[i];
					x[i + 1] ^= res[i + 1];
				}
			}
			for (int u: res) System.out.print(u + " ");
			System.out.println();
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
