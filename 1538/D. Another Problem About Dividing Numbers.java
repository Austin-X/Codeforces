import java.io.*;
import java.util.*;

public class AnotherProblemAboutDividingNumbers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	private static final int MV = 31622;
	static boolean[] primes = new boolean[MV + 1];
	static ArrayList<Integer> p = new ArrayList<Integer>();
	
	static void sieve() {
		Arrays.fill(primes, true);
		primes[0] = false; primes[1] = false;
		for (int i = 2; i <= MV; i ++) {
			if (primes[i]) {
				for (int j = i + i; j <= MV; j += i) primes[j] = false;
			}
		}
		for (int i = 2; i <= MV; i ++) if (primes[i]) p.add(i);
	}
	
	public static void main(String[] args) throws IOException {
		sieve();
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int a = readInt(), b = readInt(), k = readInt();
			
			int factorsA = 0, factorsB = 0;
			int min = 0;
			if (a == b) min = 0;
			else if (a % b == 0 || b % a == 0) min = 1;
			else min = 2;
			
			for (int i = 0; i < p.size(); i ++) {
				while (a % p.get(i) == 0) {
					factorsA ++;
					a /= p.get(i);
				}
				if (a == 1) break;
			}
			if (a != 1) factorsA ++;
			
			for (int i = 0; i < p.size(); i ++) {
				while (b % p.get(i) == 0) {
					factorsB ++;
					b /= p.get(i);
				}
				if (b == 1) break;
			}
			if (b != 1) factorsB ++;
			int max = factorsA + factorsB;
			
			if (k >= min && k <= max) {
				if (min == 0 && k == 1) pw.println("NO");
				else pw.println("YES");
			} else pw.println("NO");
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
