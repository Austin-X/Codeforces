import java.io.*;
import java.util.*;

public class PrettyPermutations {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) a[i] = i + 1;
			if (n % 2 == 0) {
				for (int i = 0; i < n; i += 2) System.out.print(a[i + 1] + " " + a[i] + " ");
				System.out.println();
			}
			else {
				for (int i = 0; i < n - 3; i += 2) System.out.print(a[i + 1] + " " + a[i] + " ");
				System.out.println(a[n - 1] + " " + a[n - 3] + " " + a[n - 2]);
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
