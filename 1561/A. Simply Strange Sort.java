import java.io.*;
import java.util.*;

public class SimplyStrangeSort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			int[] a = new int[n + 1];
			for (int i = 1; i <= n; i ++) a[i] = readInt();
			System.out.println(solve(n, a, 1));
		}
	}

	static int solve(int n, int[] a, int it) {
		boolean flag = true;
		for (int i = 1; i <= n - 1; i ++) if (a[i] > a[i + 1]) { flag = false; break; }
		if (flag) return it - 1;
		if (it % 2 == 0) { for (int i = 2; i <= n - 1; i += 2) if (a[i] > a[i + 1]) swap(a, i, i + 1); }
		else for (int i = 1; i <= n - 2; i += 2) if (a[i] > a[i + 1]) swap(a, i, i + 1);
		return solve(n, a, it + 1);
	}
	
	static void swap (int[] a, int i, int j) {
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
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
