import java.io.*;
import java.util.*;

public class CompressionAndExpansion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			Stack<Integer> s = new Stack<Integer>();
			s.push(0);
			for (int i = 0; i < n; i ++) {
				int x = readInt();
				while (!s.isEmpty() && s.peek() + 1 != x) s.pop();
				if (!s.isEmpty()) s.pop();
				for (int u: s) pw.print(u + ".");
				pw.println(x);
				s.push(x); s.push(0);
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
