import java.io.*;
import java.util.*;

public class UnstableString {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			char[] ch = readLine().toCharArray();
			int prev = 0, n = ch.length, q = 0;
			long ans = n;
			char c = ch[0];
			if (c == '?') q ++;
			
 			for (int i = 1; i < n; i ++) {
				if (c == '0') {
					if (ch[i] == '1') {
						c = '1';
						ans += i - prev;
					} else if (ch[i] == '0') prev = i;
					else {
						c = '?';
						q ++;
						ans += i - prev;
					}
				} else if (c == '1') {
					if (ch[i] == '0') {
						c = '0';
						ans += i - prev;
					} else if (ch[i] == '1') prev = i;
					else {
						c = '?';
						q ++;
						ans += i - prev;
					}
				} else {
					if (ch[i] == '?') {
						ans += i - prev;
						q ++;
					}
					else {
						if (i - q - 1 < 0) {
							ans += q;
							c = ch[i];
						}
						else if (ch[i] == ch[i - q - 1]) {
							if (q % 2 == 0) {
								ans += q;
								prev = i - q;
								c = ch[i];
							}
							else {
								ans += i - prev;
								c = ch[i];
							}
						} else {
							if (q % 2 == 0) {
								ans += i - prev;
								c = ch[i];
							} else {
								ans += q;
								prev = i - q;
								c = ch[i];
							}
						}
						q = 0;
					}
				}
			}
 			pw.println(ans);
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
