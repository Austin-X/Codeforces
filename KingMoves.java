import java.io.*;
import java.util.*;

public class FastReaderFormat1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		String s = readLine();
		char c = s.charAt(0); int r = Character.getNumericValue(s.charAt(1));
		int moves = 8; 
		if (c == 'a' || c == 'h') moves -= 3;
		if (r == 1 || r == 8) moves -= 3;
		if ((c == 'a' || c == 'h') && (r == 1 || r == 8)) moves ++;
		System.out.println(moves);
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
