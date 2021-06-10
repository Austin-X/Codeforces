import java.io.*;
import java.util.*;

public class FriendsAndCandies {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			double sum = 0;
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) { a[i] = readInt(); sum += a[i]; }
			sum /= n;
			if (sum != Math.floor(sum)) { pw.println(-1); continue; }
			
			int diff = 0, avg = (int) sum, ans = n;
			for (int i = 0; i < n; i ++) diff += Math.abs(a[i] - avg);
			Arrays.parallelSort(a);
			for (int i = n - 1; i >= 0; i --) {
				if (diff <= 0) { ans = n - i - 1; break; }
				diff -= Math.abs(2 * (a[i] - avg));
			}
			pw.println(ans);
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
