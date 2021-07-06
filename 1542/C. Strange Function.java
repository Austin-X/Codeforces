import java.io.*;
import java.util.*;

public class StrangeFunction {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static final int MOD = (int)(1e9) + 7;
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			long n = readLong();

			int i = 2;
			long val = 1, ans = 0;
			
			while (val <= n) {
				ans += i * (n / val);
				val = lcm(val, i);
				i ++;
				ans -= (i - 1) * (n / val);
				ans %= MOD;
			}
			System.out.println(ans);
		}
	}
	
	static long gcd (long a, long b) {
		return (b == 0 ? a : gcd(b, a % b));
	}
	
	static long lcm(long a, long b) {
		return a * b / gcd(a, b);
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
