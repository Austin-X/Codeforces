import java.io.*;
import java.util.*;

public class ArrayReordering {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			int evenCnt = 0;
			ArrayList<Integer> odd = new ArrayList<Integer>();
			for (int i = 0; i < n; i ++) {
				int x = readInt();
				if (x % 2 == 0) evenCnt ++;
				else odd.add(x);
			}
			int ans = evenCnt * (2 * n - evenCnt - 1) / 2;
			for (int i = 0; i < odd.size(); i ++) {
				for (int j = i + 1; j < odd.size(); j ++) {
					if (gcd(odd.get(i), odd.get(j)) > 1) ans ++;
				}
			}
			pw.println(ans);
		}
		pw.close();
	}
	
	static int gcd (int a, int b) {
		if (a == 0) return b;
		return gcd(b % a, a);
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
