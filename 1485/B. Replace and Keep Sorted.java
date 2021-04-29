import java.io.*;
import java.util.*;

public class ReplaceAndKeepSorted {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt(), q = readInt(), k = readInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		
		long[] pfs = new long[n];
		for (int i = 1; i < n - 1; i ++) {
			pfs[i] = pfs[i - 1] + arr[i + 1] - arr[i - 1] - 2;
		}

		for (int i = 0; i < q; i ++) {
			int l = readInt() - 1, r = readInt() - 1;
			
			long ans = 0;
			if (r - l == 0) {
				ans = k - 1;
			} else if (r - l == 1) {
				ans += arr[l + 1] - 2;
				ans += k - arr[r - 1] - 1;
			} else {
				ans += arr[l + 1] - 2;
				ans += k - arr[r - 1] - 1;
				ans += pfs[r - 1] - pfs[l];
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
