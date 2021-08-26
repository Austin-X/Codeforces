import java.io.*;
import java.util.*;

public class Rings {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		while (t-- > 0) solve();
	}
	
	static void solve() throws IOException {
		int n = readInt();
		char[] ch = readLine().toCharArray();
		int mid = n / 2;
		if (n % 2 == 0) mid --;
		int idx = -1;
		for (int i = 0; i <= mid; i ++) if (ch[i] == '0') { idx = i; break; }
		if (idx != -1) { System.out.println((idx + 1) + " " + n + " " + (idx + 2) + " " + n); return; }
		idx = -1;
		for (int i = mid + 1; i < n; i ++) if (ch[i] == '0') { idx = i; break; }
		if (idx != -1) { System.out.println(1 + " " + (idx + 1) + " " + 1 + " " + idx); return; }
		System.out.println(1 + " " + (n - 1) + " " + 2 + " " + n);
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
