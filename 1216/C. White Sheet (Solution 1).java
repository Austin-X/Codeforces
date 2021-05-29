import java.awt.*;
import java.io.*;
import java.util.*;

public class WhiteSheet {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	private static final int MV = 1000000;
	static Rectangle r1;
	static boolean[] rows = new boolean[MV + 1];
	
	public static void main(String[] args) throws IOException {
		int x1 = readInt(), y1 = readInt(), x2 = readInt(), y2 = readInt();
		r1 = new Rectangle(x1, y1, x2 - x1, y2 - y1);
		x1 = readInt(); y1 = readInt(); x2 = readInt(); y2 = readInt();
		Rectangle r2 = new Rectangle(x1, y1, x2 - x1, y2 - y1);
		x1 = readInt(); y1 = readInt(); x2 = readInt(); y2 = readInt();
		Rectangle r3 = new Rectangle(x1, y1, x2 - x1, y2 - y1);		
		for (int i = r1.y; i <= r1.y + r1.height; i ++) rows[i] = true;
		
		solve(r2, r3);
		solve(r3, r2);
		boolean flag = false;
		for (int i = r1.y + 1; i <= r1.y + r1.height; i ++) if (rows[i] == true) { flag = true; break; }
		pw.println(flag ? "YES" :"NO");
		pw.close();
	}
	
	static void solve(Rectangle r2, Rectangle r3) {
		Rectangle i1 = r1.intersection(r2), i2 = r1.intersection(r3);
		if (i1.height > 0 && i1.width > 0) {
			int x = i1.x, y = i1.y, w = i1.width, h = i1.height;
			if (x == r1.x) {
				if (x + w == r1.x + r1.width) {
					for (int i = y + 1; i <= y + h; i ++) rows[i] = false;
				} else if (i2.width > 0 && i2.height > 0 && i2.x <= x + w && i2.y <= y && i2.y + i2.height >= y + h && i2.x + i2.width >= r1.x + r1.width) {
					for (int i = y + 1; i <= y + h; i ++) rows[i] = false;
				} 
			} else if (x + w >= r1.x + r1.width && i2.width > 0 && i2.height > 0 && i2.y <= y && i2.y + i2.height >= y + h && i2.x == r1.x && i2.x + i1.width >= x + w) {
				for (int i = y + 1; i <= y + h; i ++) rows[i] = false;
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
