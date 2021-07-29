import java.io.*;
import java.util.*;

public class Cobb {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt(), k = readInt();
			int[] a = new int[n + 1];
			for (int i = 1; i <= n; i ++) a[i] = readInt();

			int idx = Math.max(n - 2 * k, 1); long ans = -Long.MAX_VALUE;
			
			for (int i = idx; i <= n; i ++)
				for (int j = i + 1; j <= n; j ++) 
					ans = Math.max(ans, (long)i * j - k * (a[i] | a[j]));
        
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
