import java.io.*;
import java.util.*;

public class GameOfLife {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt(), m = readInt();
			ArrayList<Integer> arr = new ArrayList<Integer>();
			char[] ch = readLine().toCharArray();
			for (int i = 1; i <= n; i ++) {
				if (ch[i - 1] == '1') arr.add(i);
			}
			if (arr.isEmpty()) {
				for (int i = 0; i < n; i ++) pw.print("0");
				pw.println();
				continue;
			}
			else {
				for (int i = 1; i < arr.get(0) - m; i ++) pw.print("0");
				for (int i = Math.max(1, arr.get(0) - m); i <= arr.get(0); i ++) pw.print("1");
			}
			for (int i = 1; i < arr.size(); i ++) {
				int prev = arr.get(i - 1), cur = arr.get(i);
				int mid = (cur + prev) / 2;
				if (prev + m >= mid) {
					if ((cur - prev) % 2 == 0) {
						for (int j = prev + 1; j < mid; j ++) pw.print("1");
						pw.print(0);
						for (int j = mid + 1; j <= cur; j ++) pw.print("1");
					} else {
						for (int j = prev + 1; j <= cur; j ++) pw.print("1");
					}
				} else {
					for (int j = prev + 1; j <= prev + m; j ++) pw.print("1");
					for (int j = prev + m + 1; j < cur - m; j ++) pw.print("0");
					for (int j = cur - m; j <= cur; j ++) pw.print("1");
				}
			}
			for (int i = arr.get(arr.size() - 1) + 1; i <= n; i ++) {
				if (i > arr.get(arr.size() - 1) + m) pw.print("0");
				else pw.print("1");
			}
			pw.println();
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
