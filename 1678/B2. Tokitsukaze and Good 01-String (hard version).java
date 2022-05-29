import java.io.*;
import java.util.*;
 
public class TokitsukazeAndGood01StringHardVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			String str = readLine();
			int[] s = new int[n];
			for (int i = 0; i < n; i ++) s[i] = Character.getNumericValue(str.charAt(i));
			
			ArrayList<Integer> segments = new ArrayList<Integer>();
			segments.add(-1);
			int cur = s[0], len = 1;
			for (int i = 1; i < n; i ++) {
				if (s[i] != cur) {
					segments.add(len);
					len = 1;
					cur = s[i];
				} else len ++;
			}
			segments.add(len);
			
			int siz = segments.size() - 1;
			boolean[] one = new boolean[siz + 1];
			one[1] = s[0] == 0 ? false : true;
			for (int i = 2; i <= siz; i ++) one[i] = !one[i - 1];
			int[][] dp = new int[siz + 1][2];
			dp[0][0] = 1; dp[0][1] = 1;
 
			int ans = 0;
			boolean odd = false;
			
			for (int i = 1; i <= siz; i ++) {
				dp[i][0] = n + 1; dp[i][1] = n + 1;
				int idx = one[i] ? 1 : 0;
				
				if (!odd) {
					if (segments.get(i) % 2 == 1) { 
						ans ++;
						odd = true;
						dp[i][idx] = Math.min(dp[i - 1][idx], dp[i - 1][1 - idx] + 1);
						if (segments.get(i) == 1) dp[i][1 - idx] = Math.min(dp[i - 1][1 - idx], dp[i - 1][idx] + 1);
					} else {
						dp[i][idx] = Math.min(dp[i - 1][idx], dp[i - 1][1 - idx] + 1);
					}
				} else { 
					if (segments.get(i) % 2 == 1) {
						dp[i][idx] = Math.min(dp[i - 1][idx], dp[i - 1][1 - idx] + 1);
						if (segments.get(i) == 1) dp[i][1 - idx] = Math.min(dp[i - 1][1 - idx], dp[i - 1][idx] + 1);
						odd = false;
					} else {
						ans ++;
						dp[i][idx] = Math.min(dp[i - 1][idx], dp[i - 1][1 - idx] + 1);
						if (segments.get(i) == 2) dp[i][1 - idx] = Math.min(dp[i - 1][1 - idx], dp[i - 1][idx] + 1);
						else dp[i][1 - idx] = Math.min(dp[i - 1][idx] + 1, dp[i - 1][1 - idx] + 2);
					}
				}
			}
			
			System.out.println(ans + " " + Math.min(dp[siz][0], dp[siz][1]));
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
