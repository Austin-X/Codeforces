import java.awt.*;
import java.io.*;
import java.util.*;

public class WhiteSheet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
		
	public static void main(String[] args) throws IOException {
		int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
		Rectangle white = new Rectangle(x1, y1, x2 - x1, y2 - y1);
		x1 = readInt(); y1 = readInt(); x2 = readInt(); y2 = readInt();
		Rectangle black1 = new Rectangle(x1, y1, x2 - x1, y2 - y1);
		x1 = readInt(); y1 = readInt(); x2 = readInt(); y2 = readInt();
		Rectangle black2 = new Rectangle(x1, y1, x2 - x1, y2 - y1);		
		
		Rectangle wb1 = white.intersection(black1), wb2 = white.intersection(black2), overlap  = wb1.intersection(wb2);
		pw.println(getArea(white) > getArea(wb1) + getArea(wb2) - getArea(overlap) ? "YES" : "NO");
		pw.close();
	}
	
	static long getArea(Rectangle r) {
		if (r.height <= 0 || r.width <= 0) return 0;
		return (long)r.height * r.width;
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
