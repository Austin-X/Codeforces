import java.io.*;
import java.util.*;

public class SubtleSubstringSubtraction {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		while (t-- > 0) {
			char[] ch = readLine().toCharArray();
			int n = ch.length;
			
			int sum = 0;
			for (int i = 0; i < n; i ++) sum += ch[i] - 'a' + 1;
			if (n % 2 == 0) {
				System.out.println("Alice " + sum);
			} else {
				int sum1 = 0, sum2 = 0;
				for (int i = 0; i < n - 1; i ++) sum1 += ch[i] - 'a' + 1;
				for (int i = 1; i < n; i ++) sum2 += ch[i] - 'a' + 1;
				int mx = Math.max(sum1, sum2), rem = sum - mx;
				if (mx < rem) System.out.println("Bob " + (rem - mx));
				else System.out.println("Alice " + (mx - rem));
			}
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
