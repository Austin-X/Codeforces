import java.io.*;
import java.util.*;
 
public class SecretSanta {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			@SuppressWarnings("unchecked")
			TreeSet<Integer>[] adj = new TreeSet[n + 1];
			TreeSet<Integer> set = new TreeSet<Integer>();
			for (int i = 1; i <= n; i ++) {
				adj[i] = new TreeSet<Integer>();
				set.add(i);
			}
			for (int i = 1; i <= n; i ++) adj[readInt()].add(i);
			
			int[] res = new int[n + 1];
			int ans = 0, duplicates = 0;
			for (int i = 1; i <= n; i ++) {
				if (!adj[i].isEmpty()) {
					ans ++;
					duplicates += adj[i].size() - 1;
				}
			}
			
			for (int i = 1; i <= n; i ++) {
				if (!adj[i].isEmpty()) {
					res[adj[i].pollFirst()] = i;
					set.remove(i);
				}
			}
			
			if (duplicates == 1) {
				for (int i = 1; i <= n; i ++) {
					if (adj[i].size() == 1) {
						int x = 0;
						for (int j = 1; j <= n; j ++) if (res[j] == i) { x = j; break; }
						adj[i].add(x);	
						if (!set.contains(adj[i].first())) {
							res[adj[i].first()] = set.first();
							res[adj[i].last()] = i;
						} else {
							res[adj[i].last()] = set.first();
							res[adj[i].first()] = i;
						}
						break;
					}
				}
			} else {
				for (int i = 1; i <= n; i ++) {
					for (int x: adj[i]) {
						if (set.contains(x)) {
							if (x != set.first()) res[x] = set.pollFirst();
							else res[x] = set.pollLast();
						}
					}
				}
				for (int i = 1; i <= n; i ++) {
					for (int x: adj[i]) {
						if (res[x] == 0) res[x] = set.pollFirst();
					}
				}
			}
			
			System.out.println(ans);
			for (int i = 1; i <= n; i ++) System.out.print(res[i] + " ");
			System.out.println();
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
