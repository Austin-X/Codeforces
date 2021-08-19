import java.io.*;
import java.util.*;

public class DislikeOfThrees {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		int[] ans = new int[1001];
		int cur = 1;
		for (int i = 1; i <= 1000; i ++) {
			ans[i] = cur;
			while (true) {
				cur ++;
				if (cur % 3 == 0 || cur % 10 == 3) continue;
				break;
			}
		}
		while (t-- > 0) {
			int k = readInt();
			System.out.println(ans[k]);
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
