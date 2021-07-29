import java.io.*;
import java.util.*;
 
public class Cherry {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
			
		while (t-- > 0) {
			int n = readInt();
			long ans = 0;
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			for (int i = 0; i < n - 1; i ++) ans = Math.max(ans, (long)a[i] * a[i + 1]);
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
