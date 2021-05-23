import java.io.*;
import java.util.*;

public class SequencePairWeight {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			long ans = 0;
			HashMap<Integer, Long> map = new HashMap<Integer, Long>();

			for (int i = 1; i <= n; i ++) {
				int x = readInt();
				if (map.containsKey(x)) ans += map.get(x) * (n - i + 1);
				map.putIfAbsent(x, 0L);
				map.put(x, map.get(x) + i);
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
