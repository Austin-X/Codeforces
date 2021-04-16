import java.io.*;
import java.util.*;

public class AverageHeight {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			
			ArrayList<Integer> even = new ArrayList<Integer>(), odd = new ArrayList<Integer>();
			for (int i = 0; i < n; i ++) {
				int x = readInt();
				if (x % 2 == 0) even.add(x);
				else odd.add(x);
			}
			
			for (int x : even) System.out.print(x + " ");
			for (int x : odd) System.out.print(x + " ");
			System.out.println();
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
