import java.io.*;
import java.util.*;

public class TMTDocument {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			char[] ch = readLine().toCharArray();
			
			boolean flag = true;
			Queue<Integer> s = new LinkedList<Integer>();
			ArrayList<Integer> f = new ArrayList<Integer>();
			boolean[] vis = new boolean[n];
			
			for (int i = 0; i < n; i ++) {
				if (ch[i] == 'T') {
					s.add(i);
				} else {
					if (s.isEmpty()) {
						flag = false;
						break;
					} else {
						vis[s.poll()] = true;
						f.add(i);
					}
				}
			}
			
			if (flag && s.size() == f.size()) {
				int idx = 0;
				for (int x : s) {
					if (x < f.get(idx)) {
						flag = false;
						break;
					}
					idx ++;
				}
				System.out.println(flag ? "YES" : "NO");
			} else  System.out.println("NO");
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
