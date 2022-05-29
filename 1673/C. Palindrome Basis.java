import java.io.*;
import java.util.*;

public class PalindromeBasis {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static boolean isPalindrome(int x) {
		String s = String.valueOf(x);
		for (int i = 0; i < s.length() / 2; i ++) if (s.charAt(i) != s.charAt(s.length() - i - 1)) return false;
		return true;
	}
	
	private static int MX = (int) (4 * 1e4), MOD  = (int) (1e9 + 7);
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		ArrayList<Integer> palindromes = new ArrayList<Integer>();
		for (int i = 1; i <= MX; i ++) if (isPalindrome(i)) palindromes.add(i);
		int siz = palindromes.size();
		
		int[][] dp = new int[MX + 1][siz];
		for (int i = 0; i < siz; i ++) dp[0][i] = 1;
		
		for (int i = 1; i <= MX; i ++) {
			for (int j = siz - 1; j >= 0; j --) {
				if (i - palindromes.get(j) >= 0) {
					dp[i][j] = dp[i - palindromes.get(j)][j];
					if (j != siz - 1) dp[i][j] += dp[i][j + 1];
					dp[i][j] %= MOD;
				}
			}
		}
		
		while (t-- > 0) System.out.println(dp[readInt()][0]);
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
