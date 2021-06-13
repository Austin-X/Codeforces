import java.io.*;
import java.util.*;

public class ColourTheFlag {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt(), m = readInt();
			char[][] grid = new char[n][m], ans1 = new char[n][m], ans2 = new char[n][m];
			for (int i = 0; i < n; i ++) grid[i] = readLine().toCharArray();
			
			boolean bool = true, flag1 = true, flag2 = true;
			for (int i = 0; i < n; i ++) {
				for (int j = 0; j < m; j ++) {
					if (bool) { ans1[i][j] = 'R'; ans2[i][j] = 'W'; }
					else if (!bool) { ans1[i][j] = 'W'; ans2[i][j] = 'R'; }
					bool = !bool;
					if (ans1[i][j] == 'R' && grid[i][j] == 'W' || ans1[i][j] == 'W' && grid[i][j] == 'R') flag1 = false;
					if (ans2[i][j] == 'R' && grid[i][j] == 'W' || ans2[i][j] == 'W' && grid[i][j] == 'R') flag2 = false;
				}
				if (i % 2 == 0) bool = false;
				else bool = true;
			}
			if (flag1) {
				pw.println("YES");
				for (int i = 0; i < n; i ++) 
					for (int j = 0; j < m; j ++) pw.print(j == m - 1 ? ans1[i][j] + "\n" : ans1[i][j]);
			} else if (flag2) {
				pw.println("YES");
				for (int i = 0; i < n; i ++) 
					for (int j = 0; j < m; j ++) pw.print(j == m - 1 ? ans2[i][j] + "\n" : ans2[i][j]);
			} else pw.println("NO");
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
