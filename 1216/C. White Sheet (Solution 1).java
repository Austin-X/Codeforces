import java.io.*;
import java.util.*;

public class WhiteSheet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	static boolean flag = false;
	static int x3, y3, x4, y4, x5, y5, x6, y6;
	public static void main(String[] args) throws IOException {
		int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
		x3 = readInt(); y3 = readInt(); x4 = readInt(); y4 = readInt();
		x5 = readInt(); y5 = readInt(); x6 = readInt(); y6 = readInt();
		
		for (double i = y1; i <= y2; i += 0.5) { check(x1, i); check(x2, i); }
		for (double i = x1; i <= x2; i += 0.5) { check(i, y1); check(i, y2); }

		pw.println(flag ? "YES" :"NO");
		pw.close();
	}
	
	static void check(double x, double y) {
		if (x >= x3 && x <= x4 && y >= y3 && y <= y4 || x >= x5 && x <= x6 && y >= y5 && y <= y6) return;
		flag = true;
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
