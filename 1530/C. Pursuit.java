import java.io.*;
import java.util.*;

public class Pursuit {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt(), k = (int) (n - Math.floor(n / 4)), sumA = 0, sumB = 0;
		    Integer[] a = new Integer[n], b = new Integer[n];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			for (int i = 0; i < n; i ++) b[i] = readInt();
			Arrays.parallelSort(a); Arrays.parallelSort(b);

			for (int i = n - k; i < n; i ++) { sumA += a[i]; sumB += b[i]; }
			int temp = n + 1, idx = n - k - 1, aIdx = n - k, ans = 0, diff = sumB - sumA;
			
			while (diff > 0) {
				if (idx < 0 && aIdx >= n) break;
				
				if (temp % 4 == 0) { 
					diff -= 100; 
					if (aIdx < n) { diff += a[aIdx]; aIdx ++; }
					else diff += 100;
				} else { 
					diff -= 100; 
					if (idx >= 0) {
						diff += b[idx]; 
						idx --; 
					}
				}
				temp ++;
				ans ++;
			}
			if (diff > 0) {
				int x = (int)Math.ceil(diff / 100d), y = x / 4;
				ans += x + y;
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
