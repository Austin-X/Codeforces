import java.io.*;
import java.util.*;
 
public class DeepDownBelow {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Pair implements Comparable<Pair> {
		int best, k;
		Pair (int best, int k) { this.best = best; this.k = k; }
		public int compareTo (Pair p) { return Integer.compare(best, p.best); }
	}
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt(), ans = 0, cnt = 0;
			
			Pair[] c = new Pair[n];
			for (int i = 0; i < n; i ++) {
				int k = readInt();
				int p = 0;
				for (int j = 0; j < k; j ++) {
					int x = readInt();
					p = Math.max(p, x - j + 1);
				}
				c[i] = new Pair(p, k);
			}
			
			Arrays.parallelSort(c);
			for (int i = 0; i < n; i ++) {
				ans = Math.max(ans, c[i].best - cnt);
				cnt += c[i].k;
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
