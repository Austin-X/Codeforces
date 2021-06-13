import java.io.*;
import java.util.*;

public class LittleAlawnsPuzzle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	static final int MOD = (int) (1e9 + 7);
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			int[] map1 = new int[n + 1], map2 = new int[n + 1], m1 = new int[n + 1], m2 = new int[n + 1];
			int[][] arr = new int[2][n + 1];
			boolean[] vis = new boolean[n + 1];
			
			for (int i = 0; i < 2; i ++)
				for (int j = 1; j <= n; j ++) arr[i][j] = readInt();
			
			for (int i = 1; i <= n; i ++) {
				map1[arr[0][i]] = arr[1][i];
				map2[arr[1][i]] = arr[0][i];
				m1[arr[0][i]] = i;
				m2[arr[1][i]] = i;
			}
			
			int ans = 1, cycles = 0;
			for (int i = 1; i <= n; i ++) {
				int cur = i;
				while (true) {
					if (vis[cur]) break;
					if (map1[arr[1][cur]] == arr[0][i]) { vis[cur] = true; vis[m1[arr[1][cur]]] = true; cycles ++; break; }
					else { vis[cur] = true; cur = m1[arr[1][cur]]; }
				}
			}
			
			for (int i = 0; i < cycles; i ++) {
				ans *= 2;
				ans %= MOD;
			}
			pw.println(ans);
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
