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
			long even, odd;
			if (n % 2 == 0) { even = n / 2; odd = n / 2; }
			else { even = n / 2; odd = n / 2 + 1;  }
			long ans = (even * 3 + odd * 2) % MOD, cur = 6, mult = 3;

			while (cur <= n) {
				ans -= (n / cur) * mult;
				ans += (n / cur) * (mult + 1);
				ans %= MOD;
				mult ++;
				cur = lcm(cur, mult);
			}
			System.out.println(ans);
		}
	}
	
	static long gcd (long a, long b) {
		return (b == 0 ? a: gcd(b, a % b));
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
