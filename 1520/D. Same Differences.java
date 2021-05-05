import java.io.*;
import java.util.*;

public class SameDifferences {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			int[] a = new int[n + 1];
			for (int i = 1; i <= n; i ++) a[i] = readInt();
			
			long ans = 0;
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			map.put(a[1], 1);
			for (int i = 2; i <= n; i ++) {
				if (map.containsKey(a[i] - i + 1)) ans += map.get(a[i] - i + 1);
				map.putIfAbsent(a[i] - i + 1, 0);
				map.put(a[i] - i + 1, map.get(a[i] - i + 1) + 1);
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
