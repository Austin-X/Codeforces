import java.io.*;
import java.util.*;

public class AquamoonAndStolenString {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt(), m = readInt();
			String[] a = new String[n], b = new String[n - 1];
			char[][] freq1 = new char[m][26], freq2 = new char[m][26];
			for (int i = 0; i < n; i ++) {
				a[i] = readLine();
				for (int j = 0; j < m; j ++) freq1[j][a[i].charAt(j) - 'a'] ++;
			}
			for (int i = 0; i < n - 1; i ++) {
				b[i] = readLine();
				for (int j = 0; j < m; j ++) freq2[j][b[i].charAt(j) - 'a'] ++;
			}
			for (int i = 0; i < m; i ++) {
				for (int j = 0; j < 26; j ++) {
					if (freq1[i][j] != freq2[i][j]) {
						System.out.print((char)(j + 'a'));
						break;
					}
				}
			}
			System.out.println();
			System.out.flush();
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
