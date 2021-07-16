import java.io.*;
import java.util.*;

public class ArrayStabilizationGCDVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	static int[] STree;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			
			STree = new int[4 * n];
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			build(a, 0, n - 1, 0);
			int gcd = STree[0], ans = 0;
			
			int temp, r = 0;
			for (int i = 0; i < n; i ++) {
				if (r < i) temp = gcd(getGcd(0, r, 0, n - 1, 0), getGcd(i, n - 1, 0, n - 1, 0));
				else temp = getGcd(i, r, 0, n - 1, 0);
				while (temp != gcd) {
					r ++;
					if (r == n) r = 0;
					temp = gcd(temp, a[r]);
				}

				if (r < i) ans = Math.max(ans, r + n - i);
				else ans = Math.max(ans, r - i);
				if (r == i) r ++;
			}
			System.out.println(ans);
		}
	}

	static int gcd (int a, int b) {
		return b == 0 ? a : gcd(b, a % b);
	}
	
	static int build (int[] a, int low, int high, int pos) {
		int mid = (low + high) / 2;
		if (low == high) { return STree[pos] = a[low]; }
		return STree[pos] = gcd(build(a, low, mid, pos * 2 + 1), build(a, mid + 1, high, pos * 2 + 2)); 
	}
	
	static int getGcd (int low, int high, int l, int r, int pos) {
		if (low <= l && high >= r) return STree[pos];
		int mid = (l + r) / 2;
		if (high <= mid) return getGcd(low, high, l, mid, pos * 2 + 1);
		if (low > mid) return getGcd(low, high, mid + 1, r, pos * 2 + 2);
		return gcd(getGcd(low, high, l, mid, pos * 2 + 1), getGcd(low, high, mid + 1, r, pos * 2 + 2));
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
