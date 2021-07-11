import java.io.*;
import java.util.*;

public class AirConditioners {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	static class Pair implements Comparable<Pair> {
		int idx, t;
		Pair (int idx, int t) { this.idx = idx; this.t = t; }
		public int compareTo(Pair p) { 
			if (t == p.t) return Integer.compare(idx, p.idx);
			return Integer.compare(t, p.t); 
		}
	}
	
	public static void main(String[] args) throws IOException {
		int q = readInt();
		
		while (q-- > 0) {
			int n = readInt(), k = readInt();
			int[] a = new int[k], t = new int[k];
			TreeSet<Pair> set = new TreeSet<Pair>();
			for (int i = 0; i < k; i ++) a[i] = readInt();
			for (int i = 0; i < k; i ++) t[i] = readInt();
			for (int i = 0; i < k; i ++) set.add(new Pair(a[i], t[i]));
			int[] res = new int[n + 1];
			while (!set.isEmpty()) {
				Pair cur = set.pollFirst();
				if (res[cur.idx] == 0) {
					res[cur.idx] = cur.t;
					if (cur.idx > 1) set.add(new Pair(cur.idx - 1, cur.t + 1));
					if (cur.idx < n) set.add(new Pair(cur.idx + 1, cur.t + 1));
				}
			}
			for (int i = 1; i <= n; i ++) System.out.print(i == n ? res[i] + "\n" : res[i] + " ");
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
