import java.io.*;
import java.util.*;

public class ScenesFromAMemory {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int k = readInt();
			char[] nTemp = readLine().toCharArray();
			int[] n = new int[k];
			for (int i = 0; i < k; i ++) n[i] = Character.getNumericValue(nTemp[i]);
			solve(k, n);
		}
	}
	
	static void solve(int k, int[] n) {
		int[] cnt = new int[10];
		for (int x: n) cnt[x] ++;
		for (int i = 1; i < 10; i ++) if (cnt[i] > 0 && (i == 1 || i == 4 || i == 6 || i == 8 || i == 9)) { System.out.println(1 + "\n" + i); return; }
		
		System.out.println(2);
		if (k == 2) { System.out.println(n[0] * 10 + n[1]); return; }
		int v1 = n[0] * 10 + n[1], v2 = n[0] * 10 + n[2], v3 = n[1] * 10 + n[2];
		if (!isPrime(v1)) System.out.println(v1);
		else if (!isPrime(v2)) System.out.println(v2);
		else System.out.println(v3);	
	}
	
	static boolean isPrime(int x) {
		int sqrt = (int) Math.sqrt(x);
		for (int i = 2; i <= sqrt; i ++) if (x % i == 0) return false;
		return true;
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
