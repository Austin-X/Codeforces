import java.io.*;
import java.util.*;

public class NotAdjacentMatrix {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			
			if (n == 2) System.out.println(-1);
			else {
				int idx = 1;
				for (int i = 1; i <= n; i ++) {
					for (int j = 1; j < n; j ++) {
						System.out.print(idx + " ");
						idx += 2;
						if (idx > n * n) idx = 2;
					}
					System.out.println(idx);
					idx += 2;
					if (idx > n * n) idx = 2;
				}
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
