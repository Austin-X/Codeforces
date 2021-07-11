import java.io.*;
import java.util.*;

public class AlphabeticalStrings {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			char[] ch = readLine().toCharArray();
			int n = ch.length;
			char cur = 'a';
			int min = -1, max = -1;
			for (int i = 0; i < ch.length; i ++) if (ch[i] == 'a') { cur ++; min = i; max = i; break; }
			
			boolean b = true;
			if (min == -1 && max == -1) b = false;
			for (int i = 1; i < n; i ++) {
				if (min > 0 && ch[min - 1] == cur) { min --; cur ++; }
				else if (max < n - 1 && ch[max + 1] == cur) { max ++; cur ++; }
				else { b = false; break; }
			}
			System.out.println(b ? "YES" : "NO");
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
