import java.io.*;
import java.util.*;

public class DeletingDivisors {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			boolean containsOddFactor = false;
			int evenFactorCnt = 0;
			for (int i = 2; i * i <= n; i ++) {
				while (n % i == 0) {
					if (i == 2) evenFactorCnt ++;
					else containsOddFactor = true;
					n /= i;
				}
			}
			if (n != 1) containsOddFactor = true;
			
			if (evenFactorCnt == 0) System.out.println("Bob");
			else {
				if (containsOddFactor || evenFactorCnt % 2 == 0) System.out.println("Alice");
				else System.out.println("Bob");
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
