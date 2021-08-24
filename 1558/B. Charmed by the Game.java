import java.io.*;
import java.util.*;
 
public class CharmedByTheGame {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int a = readInt(), b = readInt(), n = a + b;
			boolean[] vis = new boolean[n + 1];
			int spotsA = n / 2, spotsB = n / 2;
			if (n % 2 == 1) spotsA ++;
			for (int i = 0; i <= b; i ++) {
				if (i <= spotsA) {
					if (spotsB >= b - i) vis[i + spotsB - (b - i)] = true;
				} else vis[spotsA + spotsB - (b - spotsA)] = true;
				
				if (i <= spotsB) {
					if (spotsA >= b - i) vis[i + spotsA - (b - i)] = true;
				} else vis[spotsB + spotsA - (b - spotsB)] = true;
			}
			Queue<Integer> q = new LinkedList<Integer>();
			int cnt = 0;
			for (int i = 0; i <= n; i ++) if (vis[i]) { q.add(i); cnt ++; }
			System.out.println(cnt);
			while (!q.isEmpty()) System.out.print(q.poll() + " ");
			System.out.println();
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
