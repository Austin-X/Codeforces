import java.io.*;
import java.util.*;

public class EshagLovesBigArrays {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			Arrays.sort(a);
			int min = a[0], ans = 0;
			for (int i = 1; i < n; i ++) if (a[i] != min) ans ++;
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
