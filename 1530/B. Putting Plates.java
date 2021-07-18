import java.io.*;
import java.util.*;

public class PuttingPlates {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int h = readInt(), w = readInt();
			
			boolean[][] b = new boolean[h][w];
			for (int i = 0; i < h; i ++) {
				for (int j = 0; j < w; j ++) {
					if (i == 0 || i == h - 1 || j == 0 || j == w - 1) {
						boolean flag = true;
						if (i > 0 && b[i - 1][j]) flag = false;
						if (j > 0 && b[i][j - 1]) flag = false;
						if (i > 0 && j > 0 && b[i - 1][j - 1]) flag = false;
						if (i > 0 && j < w - 1 && b[i - 1][j + 1]) flag = false;
						if (flag) {
							System.out.print(1);
							b[i][j] = true;
						} else System.out.print(0);
					} else System.out.print(0);
				}
				System.out.println();
			}
			System.out.println();
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
