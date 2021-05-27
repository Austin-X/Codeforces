import java.io.*;
import java.util.*;

public class PalindromeGameHardVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			char[] ch = readLine().toCharArray();
			int zeroCnt = 0, pairs = 0;
			for (int i = 0; i < n / 2; i ++) {
				if (ch[i] == '0' && ch[i] == ch[n - i - 1]) pairs ++;
				if (ch[i] == '0') zeroCnt ++;
				if (ch[n - i - 1] == '0') zeroCnt ++;
			}
			if (n % 2 == 1 && ch[n / 2] == '0') zeroCnt ++;
			
			int extra = zeroCnt - pairs * 2;
			if (n % 2 == 0) {
				if (extra >= 1) pw.println("ALICE");
				else pw.println("BOB");
			} else {
				if (ch[n / 2] == '0') {
					if (pairs >= 1 || zeroCnt >= 3) pw.println("ALICE");
					else if (zeroCnt == 1) pw.println("BOB");
					else if (zeroCnt == 2) pw.println("DRAW");
				} else {
					if (extra >= 1) pw.println("ALICE");
					else pw.println("BOB");
				}
			}
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
