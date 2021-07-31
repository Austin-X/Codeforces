import java.io.*;
import java.util.*;

public class CoinRows {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int m = readInt(), ans = Integer.MAX_VALUE;
			int[][] pfs = new int[2][m];
			for (int i = 0; i < 2; i ++)
				for (int j = 0; j < m; j ++) pfs[i][j] = j == 0 ? readInt() : readInt() + pfs[i][j - 1];
			
			for (int i = 0; i < m; i ++) {
				int val1 = 0, val2 = 0, best = Integer.MAX_VALUE;
				if (i != m - 1) val1 = pfs[0][m - 1] - pfs[0][i];
				if (i != 0) val2 = pfs[1][i - 1];
				best = Math.max(val1, val2);
				ans = Math.min(ans, best);
			}
			System.out.println(ans);
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
