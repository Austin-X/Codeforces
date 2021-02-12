import java.io.*;
import java.util.*;

public class LongNumber {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int n = readInt(); String str = readLine();
		int[] map = new int[10];
		for (int i = 1; i <= 9; i ++) map[i] = readInt();

		boolean flag = true, change = false;
		for (int i = 0; i < n; i ++) {
			int val = Character.getNumericValue(str.charAt(i));
			if (flag) {
				if (!change && map[val] > val) { change = true; System.out.print(map[val]); }
				else if (!change && map[val] <= val) System.out.print(val);
				else if (change && map[val] >= val) System.out.print(map[val]);
				else if (change && map[val] < val) { flag = false; System.out.print(val); }
			} else System.out.print(val);
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
