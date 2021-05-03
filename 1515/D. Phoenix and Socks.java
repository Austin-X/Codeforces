import java.io.*;
import java.util.*;

public class PhoenixAndSocks {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			n = readInt(); 
			int l = readInt(), r = readInt();
			int[] c = new int[n + 1];
			for (int i = 1; i <= l; i ++) c[readInt()] ++;
			for (int i = 1; i <= r; i ++) c[readInt()] --;
			
			ArrayList<Integer> lTemp = new ArrayList<Integer>(), rTemp = new ArrayList<Integer>();
			for (int i = 1; i <= n; i ++) {
				if (c[i] > 0) {
					for (int j = 0; j < c[i]; j ++) lTemp.add(i);
				} else if (c[i] < 0) {
					for (int j = 0; j < -c[i]; j ++) rTemp.add(i);
				}
			}
			int[] left = new int[lTemp.size() + 1], right = new int[rTemp.size() + 1];
			for (int i = 0; i < lTemp.size(); i ++) left[i + 1] = lTemp.get(i);
			for (int i = 0; i < rTemp.size(); i ++) right[i + 1] = rTemp.get(i);

			int ans = 0;
			if (left.length == right.length) ans = left.length - 1;
			else if (l < r) ans = calc(left.length - 1, right.length - 1, left, right);
			else ans = calc(right.length - 1, left.length - 1, right, left);
			System.out.println(ans);
		}
	}
	
	static int calc (int l, int r, int[] left, int[] right) {
		int ans = 0;
		int diff = r - l;
		
		int[] colour = new int[n + 1];
		for (int i = 1; i <= r; i ++) {
			colour[right[i]] ++;
			if (diff > 0 && colour[right[i]] == 2) {
				colour[right[i]] = 0;
				diff -= 2;
				ans ++;
			}
		}

		if (diff == 0) ans += l;
		else ans += l + diff;
	
		return ans;
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
