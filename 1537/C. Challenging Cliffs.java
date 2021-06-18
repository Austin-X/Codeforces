import java.io.*;
import java.util.*;

public class ChallengingCliffs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			Integer[] h = new Integer[n];
			TreeMap<Integer, Integer> freq = new TreeMap<Integer, Integer>();
			for (int i = 0; i < n; i ++) { 
				h[i] = readInt(); 
				freq.putIfAbsent(h[i], 0);
				freq.put(h[i], freq.get(h[i]) + 1);
			}
			
			int best = 3, ansX = 0, ansY = 0;
			Arrays.sort(h);
			HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
			int minDiff = Integer.MAX_VALUE;
			for (int i = 0; i < n - 1; i ++) minDiff = Math.min(minDiff, h[i + 1] - h[i]);
			for (int i = 0; i < n - 1; i ++) if (h[i + 1] - h[i] == minDiff) map.put(h[i], h[i + 1]);
			for (int x: map.keySet()) {
				int y = map.get(x);
				freq.put(x, freq.get(x) - 1);
				if (freq.get(x) == 0) freq.remove(x);
				freq.put(y, freq.get(y) - 1);
				if (freq.get(y) == 0) freq.remove(y);
				int ans = 0;
				if (freq.lowerKey(x) != null) {
					ans ++;
					if (freq.lowerKey(x) >= y) ans ++;
				}
				if (ans < best) {
					best = ans;
					ansX = x;
					ansY = y;
				}
				freq.putIfAbsent(x, 0);
				freq.put(x, freq.get(x) + 1);
				freq.putIfAbsent(y, 0);
				freq.put(y, freq.get(y) + 1);
			}
			
			pw.print(ansX + " ");
			freq.put(ansX, freq.get(ansX) - 1);
			if (freq.get(ansX) == 0) freq.remove(ansX);
			freq.put(ansY, freq.get(ansY) - 1);
			if (freq.get(ansY) == 0) freq.remove(ansY);
			for (int x: freq.keySet()) {
				if (x >= ansX) {
					for (int i = 0; i < freq.get(x); i ++) pw.print(x + " ");
				}
			}
			for (int x: freq.keySet()) {
				if (x < ansX) {
					for (int i = 0; i < freq.get(x); i ++) pw.print(x + " ");
				}
			}
			pw.println(ansY);
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
