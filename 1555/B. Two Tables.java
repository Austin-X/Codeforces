import java.io.*;
import java.util.*;

public class TwoTables {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int W = readInt(), H = readInt();
			int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
			int w = readInt(), h = readInt();
			int ans = Integer.MAX_VALUE;
			if (x2 + w - x1 <= W) ans = Math.min(ans, w - x1);
			if (x1 - (x2 - (W - w)) >= 0) ans = Math.min(ans, x2 - (W - w));
			if (y2 + h - y1 <= H) ans = Math.min(ans, h - y1);
			if (y1 - (y2 - (H - h)) >= 0) ans = Math.min(ans, y2 - (H - h));
			System.out.println(ans == Integer.MAX_VALUE ? -1 : Math.max(ans, 0));
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
