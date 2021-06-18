import java.io.*;
import java.util.*;

public class EraseAndExtendEasyVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		String s = readLine();
		
		for (int i = 1; i < n; i ++) {
			if (i + i <= n) {
				if (s.substring(0, i).compareTo(s.substring(i, i + i)) < 0) {
					s = s.substring(0, i) + s.substring(0, i);
					break;
				}
			} else {
				if (s.substring(0, i).compareTo(s.substring(i, s.length())) < 0) {
					s = s.substring(0, i) + s.substring(0, i);
					break;
				}
			}
		}
		while (s.length() < k) s = s + s;
		pw.println(s.substring(0, k));
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
