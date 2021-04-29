import java.io.*;
import java.util.*;

public class RedAndBlueBeans {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int r = readInt(), b = readInt(), d = readInt();
			
			if (r > b) {
				if ((long)r <= (long)b * (d + 1)) System.out.println("YES");
				else System.out.println("NO");
			} else {
				if ((long)b <= (long)r * (d + 1)) System.out.println("YES");
				else System.out.println("NO"); 
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
