import java.io.*;
import java.util.*;

public class OrdinaryNumbers {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		TreeSet<Integer> nums = new TreeSet<Integer>();
		String s = "";
		for (int i = 1; i <= 9; i ++) {
			s = "";
			for (int j = 1; j <= 9; j ++) {
				s += String.valueOf(i);
				nums.add(Integer.parseInt(s));
			}
		}
		ArrayList<Integer> arr = new ArrayList<Integer>(nums);

		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int idx = Collections.binarySearch(arr, readInt());
			if (idx >= 0) System.out.println(idx + 1);
			else System.out.println(-idx - 1);
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
