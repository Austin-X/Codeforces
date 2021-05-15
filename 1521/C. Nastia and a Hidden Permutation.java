import java.io.*;
import java.util.*;

public class NastiaAndAHiddenPermutation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			boolean[] vis = new boolean[n + 1];
			int[] ans = new int[n + 1];
			for (int i = 1; i <= n; i += 2) {
				if (i + 1 > n) break;
				System.out.println("? " + 1 + " " + i + " " + (i + 1) + " " + (n - 1));
				System.out.flush();
				int x = readInt();
				
				int mx = 0;
				if (x == n - 1) {
					System.out.println("? " + 1 + " " + (i + 1) + " " + i + " " + (n - 1));
					System.out.flush();
					int y = readInt();
					if (y == n) mx = n;
					else mx = x;
				} else mx = x;
				
				System.out.println("? " + 1 + " " + i + " " + (i + 1) + " " + (mx - 1));
				System.out.flush();
				int w = readInt();
				if (w == mx - 1) {
					ans[i] = mx;
					System.out.println("? " + 2 + " " + (i + 1) + " " + i + " " + 1);
					System.out.flush();
					ans[i + 1] = readInt();
				} else {
					ans[i + 1] = mx;
					System.out.println("? " + 2 + " " + i + " " + (i + 1) + " " + 1);
					System.out.flush();
					ans[i] = readInt();
				}
				vis[ans[i]] = true;
				vis[ans[i + 1]] = true;
			}
			
			int rem = 0;
			for (int i = 1; i <= n; i ++) if (!vis[i]) rem = i;
			if (n % 2 == 1) ans[n] = rem;
			
			System.out.print("! ");
			for (int i = 1; i < n; i ++) System.out.print(ans[i] + " ");
			System.out.println(ans[n]);
			System.out.flush();
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
