import java.io.*;
import java.util.*;

public class PairProgramming {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int k = readInt(), n = readInt(), m = readInt();
			int[] a = new int[n], b = new int[m];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			for (int i = 0; i < m; i ++) b[i] = readInt();
			int aIdx = 0, bIdx = 0;
			int[] res = new int[n + m];
			boolean flag = true;
			for (int i = 0; i < n + m; i ++) {
				if (aIdx < n && a[aIdx] == 0) { res[i] = 0; aIdx ++; k ++; continue; }
				if (bIdx < m && b[bIdx] == 0) { res[i] = 0; bIdx ++; k ++; continue; }
				if (aIdx < n && a[aIdx] <= k) { res[i] = a[aIdx]; aIdx ++; continue; }
				if (bIdx < m && b[bIdx] <= k) { res[i] = b[bIdx]; bIdx ++; continue; }
				flag = false; break;
			}
			if (!flag) System.out.println(-1);
			else {
				for (int x: res) System.out.print(x + " ");
				System.out.println();
			}
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
