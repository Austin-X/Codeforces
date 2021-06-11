import java.io.*;
import java.util.*;
 
public class NumberOfPairs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt(), l = readInt(), r = readInt();
			long ans = 0;
			Integer[] a = new Integer[n];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			Arrays.sort(a);
			for (int i = 0; i < n; i ++) {
				int lb = l - a[i], ub = r - a[i];
				int low = lower_bound(a, i, lb), high = upper_bound(a, i, ub);
				ans += high - low;
			}
			pw.println(ans);
		}
		pw.close();
	}
	
	static int lower_bound (Integer[] arr, int up, int x) {
		int low = 0, high = up, mid = -1;
 
		while (low < high) {
			mid = (low + high) / 2;
			if (arr[mid] >= x) high = mid;
			else low = mid + 1;
		}
		return low;
	}
 
	static int upper_bound (Integer[] arr, int up, int x) {
		int low = 0, high = up, mid = -1;
 
		while (low < high) {
			mid = (low + high) / 2;
			if (arr[mid] > x) high = mid;
			else low = mid + 1;
		}
		return low;
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
