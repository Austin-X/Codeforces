import java.io.*;
import java.util.*;

public class EraseAndExtendHardVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int n = readInt(), k = readInt();
		String s = readLine();
		
		int idx = 0, ans = n, repeat = -1;
		for (int i = 1; i < n; i ++) {
			if (s.charAt(i) > s.charAt(idx)) {
				if (repeat != -1) ans = repeat;
				else ans = i;
				break;
			} else if (s.charAt(i) == s.charAt(idx)) {
				if (repeat == -1) repeat = i;
				idx ++;
				if (idx == repeat) idx = 0;
			} else if (repeat != -1 && s.charAt(i) < s.charAt(idx)) {
				repeat = i + 1;
				idx = 0;
			}
		}

		int temp = 0;
		for (int i = 0; i < k; i ++) {
			pw.print(s.charAt(temp));
			temp ++;
			if (temp == ans) temp = 0;
		}
		pw.println();
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
