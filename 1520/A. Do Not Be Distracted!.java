import java.io.*;
import java.util.*;

public class DoNotBeDistracted {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			char[] ch = readLine().toCharArray();
			ArrayList<Character> arr = new ArrayList<Character>();
			boolean flag = true;
			for (int i = 0; i < n; i ++) {
				if (!arr.isEmpty() && arr.get(arr.size() - 1) != ch[i] && arr.contains(ch[i])) {
					flag = false;
					break;
				}
				arr.add(ch[i]);
			}
			System.out.println(flag ? "YES" : "NO");
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
