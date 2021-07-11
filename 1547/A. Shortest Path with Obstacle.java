import java.io.*;
import java.util.*;

public class ShortestPathWithObstacle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int xa = readInt(), ya = readInt(), xb = readInt(), yb = readInt(), xf = readInt(), yf = readInt();
			int minY = Math.min(ya, yb), maxY = Math.max(ya, yb), maxX = Math.max(xa, xb), minX = Math.min(xa, xb);
			if (xa == xb) {
				if (xf == xa && yf > minY && yf < maxY) System.out.println(maxY - minY + 2);
				else System.out.println(maxY - minY);
			} else if (ya == yb) {
				if (yf == ya && xf > minX && xf < maxX) System.out.println(maxX - minX + 2);
				else System.out.println(maxX - minX);
			} else System.out.println(maxX - minX + maxY - minY);
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
