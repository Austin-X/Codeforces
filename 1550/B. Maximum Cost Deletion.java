import java.io.*;
import java.util.*;

public class MaximumCostDeletion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt(), a = readInt(), b = readInt(), ans = 0;
			char[] ch = readLine().toCharArray();
			if (b >= 0) ans = n * a + n * b;
			else {
				int segments0 = 0, segments1 = 0;
				boolean onZero = ch[0] == '0';
				for (int i = 1; i < n; i ++) {
					if (onZero && ch[i] == '1') { onZero = false; segments0 ++; }
					else if (!onZero && ch[i] == '0') { onZero = true; segments1 ++; }
				}
				if (!onZero) segments1 ++;
				else segments0 ++;
				ans = n * a + Math.min(segments0 + 1, segments1 + 1) * b;
			}
			System.out.println(ans);
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
