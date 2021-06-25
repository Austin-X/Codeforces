import java.io.*;
import java.util.*;
 
public class GreatGraphs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			Integer[] d = new Integer[n];
			for (int i = 0; i < n; i ++) d[i] = readInt();
			Arrays.parallelSort(d);
			long ans = 0;
			for (int i = 1; i < n; i ++) {
				long diff = d[i] - d[i - 1];
				ans -= (long)(n - i) * i * diff;
				ans += diff;
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
