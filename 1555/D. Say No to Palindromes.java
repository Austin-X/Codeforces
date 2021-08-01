import java.io.*;
import java.util.*;

public class SayNoToPalindromes {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), m = readInt();
		char[] ch = readLine().toCharArray();
		String[] arr = {"abc", "acb", "bac", "bca", "cab", "cba"};
		
		int[][] psa = new int[n][6];
		for (int i = 0; i < n; i ++) {
			for (int j = 0; j < 6; j ++) {
				if (arr[j].charAt(i % 3) != ch[i]) psa[i][j] = i == 0 ? 1 : psa[i - 1][j] + 1;
				else psa[i][j] = i == 0 ? 0 : psa[i - 1][j];
			}
		}
		
		while (m-- > 0) {
			int l = readInt() - 1, r = readInt() - 1, ans = Integer.MAX_VALUE;
			for (int i = 0; i < 6; i ++) ans = l == 0 ? Math.min(ans, psa[r][i]) : Math.min(ans, psa[r][i] - psa[l - 1][i]);
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
