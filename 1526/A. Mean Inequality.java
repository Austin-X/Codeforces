import java.io.*;
import java.util.*;

public class MeanInequality {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			int[] a = new int[2 * n], ans = new int[2 * n];
			for (int i = 0; i < 2 * n; i ++) a[i] = readInt();
			Arrays.sort(a); 
			int idx = 2 * n - 1;
			for (int i = 0; i < 2 * n; i += 2) {
				ans[i] = a[idx];
				idx --;
			}
			for (int i = 1; i < 2 * n; i += 2) {
				ans[i] = a[idx];
				idx --;
			}
			for (int x: ans) pw.print(x + " ");
			pw.println();
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
