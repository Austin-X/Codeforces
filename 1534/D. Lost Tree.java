import java.io.*;
import java.util.*;

public class LostTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt();
		
		boolean[][] adj = new boolean[n + 1][n + 1];
		boolean[] check = new boolean[n + 1];
		
		System.out.println("? " + 1);
		System.out.flush();
		int c1 = 0, c2 = 0;
		int[] d = new int[n + 1];
		for (int i = 1; i <= n; i ++) {
			d[i] = readInt();
			if (d[i] == 1) {
				adj[1][i] = true;
				adj[i][1] = true;
			}
			if (d[i] % 2 == 0) c1 ++;
			else c2 ++;
		}
		if (c1 <= c2) { for (int i = 2; i <= n; i ++) if (d[i] % 2 == 0) check[i] = true; }
		else { for (int i = 2; i <= n; i ++) if (d[i] % 2 == 1) check[i] = true; }
		
		for (int i = 2; i <= n; i ++) {
			if (check[i]) {
				System.out.println("? " + i);
				System.out.flush();
				for (int j = 1; j <= n; j ++) {
					int x = readInt();
					if (x == 1) {
						adj[i][j] = true;
						adj[j][i] = true;
					}
				}
			}
		}
		
		System.out.println("!");
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= n; j ++) {
				if (adj[i][j] && i < j) System.out.println(i + " " + j);
			}
		}
		System.out.flush();
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
