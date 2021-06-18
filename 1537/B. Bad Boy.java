import java.io.*;
import java.util.*;

public class BadBoy {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt(), m = readInt(), x = readInt(), y = readInt();
			pw.println("1 1 " + n + " " + m);
		}	
		pw.close();
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
