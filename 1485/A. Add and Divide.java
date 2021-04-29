import java.io.*;
import java.util.*;

public class AddAndDivide {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int a = readInt(), b = readInt();
			
			int ans = -1;
			for (int i = b; i <= 1e9; i ++) {
				if (i == 1) continue;
				
				int cnt = 0, temp = a;
				while (temp != 0) {
					temp /= i;
					cnt ++;
				}
				
				cnt += (i - b);
				if (ans == -1) ans = cnt;
				else if (cnt > ans) break;
				else if (cnt <= ans) ans = cnt;
			}
			
			System.out.println(ans);
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
