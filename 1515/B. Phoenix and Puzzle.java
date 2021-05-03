import java.io.*;
import java.util.*;

public class PhoenixAndPuzzle {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		HashSet<Integer> possible = new HashSet<Integer>();
		for (int i = 1; i <= 22360; i ++) possible.add((int) (2 * i * i));
		for (int i = 1; i <= 15811; i ++) possible.add((int) (4 * i * i));
		
		int T = readInt();
		for (int t = 0; t < T; t ++) System.out.println(possible.contains(readInt()) ? "YES" : "NO");
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
