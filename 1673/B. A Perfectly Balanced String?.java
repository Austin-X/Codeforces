import java.io.*;
import java.util.*;

public class APerfectlyBalancedString {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		while (t-- > 0) {
			char[] ch = readLine().toCharArray();
			int n = ch.length;
			boolean[] vis = new boolean[26];
			for (int i = 0; i < n; i ++) vis[ch[i] - 'a'] = true;
			
			boolean flag = true;
			outerloop: for (int i = 0; i < 26; i ++) {
				int[] freq = new int[26];
				Queue<Integer> q = new LinkedList<Integer>();
				for (int j = 0; j < n; j ++) if (ch[j] - 'a' == i) q.add(j);
				
				for (int j = 0; j < n; j ++) {
					if (ch[j] - 'a' == i || freq[i] == 1) freq[ch[j] - 'a'] ++;
					if (freq[i] == 2) {
						for (int k = 0; k < 26; k ++) if (vis[k] && Math.abs(freq[k] - freq[i]) > 1) { flag = false; break outerloop; }
						for (int k = q.poll(); k < j; k ++) freq[ch[k] - 'a'] --;
					}
				}
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
