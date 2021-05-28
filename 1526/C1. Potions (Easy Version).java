import java.io.*;
import java.util.*;

public class PotionsEasyVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);

	static class Pair implements Comparable<Pair> {
		int val, idx;
		Pair (int val, int idx) { this.val = val; this.idx = idx; }
		public int compareTo(Pair p) { 
			return -Integer.compare(val, p.val); 
		}
	}
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), ans = 0;
		int[] a = new int[n];
		long[] pfs = new long[n];
		ArrayList<Pair> arr = new ArrayList<Pair>();
		for (int i = 0; i < n; i ++) {
			a[i] = readInt();
			if (a[i] >= 0) {
				pfs[i] = i == 0 ? a[i] : pfs[i - 1] + a[i];
				ans ++;
			}
			else {
				pfs[i] = i == 0 ? 0 : pfs[i - 1];
				arr.add(new Pair(a[i], i));
			}
		}
		Collections.sort(arr);
		for (Pair x: arr) {
			boolean flag = true;
			for (int j = x.idx; j < n; j ++) if (pfs[j] + x.val < 0) { flag = false; break; }
			if (flag) {
				for (int j = x.idx; j < n; j ++) pfs[j] += x.val;
				ans ++;
			}
		}
		pw.println(ans);
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
