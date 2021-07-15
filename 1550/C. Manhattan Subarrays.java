import java.io.*;
import java.util.*;

public class ManhattanSubarrays {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt(), ans = 0;
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			
			int ll = 0, rr = 0;
			while (rr < n) {
				if (rr - ll <= 1) { ans += rr - ll + 1; rr ++; continue; }
				boolean flag = true;
				outerloop: for (int j = ll; j < rr; j ++) {
					for (int k = j + 1; k < rr; k ++) {
						int val1 = calc(a[j], j, a[k], k), val2 = calc(a[j], j, a[rr], rr), val3 = calc(a[k], k, a[rr], rr);
						if (val1 + val2 == val3 || val1 + val3 == val2 || val2 + val3 == val1) {
							flag = false; break outerloop;
						}
					}
				}
				if (flag) { ans += rr - ll + 1; rr ++; }
				else ll ++;
			}
			System.out.println(ans);
		}
	}
	
	static int calc (int a, int aIdx, int b, int bIdx) {
		return Math.abs(a - b) + Math.abs(aIdx - bIdx);
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
