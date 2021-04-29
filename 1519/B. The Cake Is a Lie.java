import java.io.*;
import java.util.*;

public class TheCakeIsALie {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Point {
		int x, y, val;
		Point (int x, int y, int val) { this.x = x; this.y = y; this.val = val; }
	}
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt(), m = readInt(), k = readInt();
			boolean flag = false;
			Queue<Point> q = new LinkedList<Point>();
			q.add(new Point(1, 1, 0));
			
			boolean[][] vis = new boolean[n + 1][m + 1];
			while (!q.isEmpty()) {
				Point p = q.poll();
				if (p.x == n && p.y == m && p.val == k) { flag = true; break; }
				if (p.y < m && !vis[p.x][p.y + 1]) { q.add(new Point(p.x, p.y + 1, p.val + p.x)); vis[p.x][p.y + 1] = true; }
				if (p.x < n && !vis[p.x + 1][p.y]) { q.add(new Point(p.x + 1, p.y, p.val + p.y)); vis[p.x + 1][p.y] = true; }
			}
			
			System.out.println(flag ? "YES" : "NO");
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
