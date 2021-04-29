import java.io.*;
import java.util.*;

public class BerlandRegional {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static class Pair implements Comparable<Pair> {
		int idx, cnt;
		Pair (int idx, int cnt) { this.idx = idx; this.cnt = cnt; }
		public int compareTo(Pair p) { return Integer.compare(cnt, p.cnt); }
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			ArrayList<Integer>[] strength = new ArrayList[n + 1];
			for (int i = 1; i <= n; i ++) strength[i] = new ArrayList<Integer>();
			int[] uni = new int[n + 1];
			for (int i = 1; i <= n; i ++) uni[i] = readInt();
			for (int i = 1; i <= n; i ++) strength[uni[i]].add(readInt());
			
			long ans = 0;
			ArrayList<Long>[] pfs = new ArrayList[n + 1];
			for (int i = 1; i <= n; i ++) pfs[i] = new ArrayList<Long>();
			
			PriorityQueue<Pair> indices = new PriorityQueue<Pair>();
			for (int i = 1; i <= n; i ++) {
				if (strength[i].isEmpty()) continue;
				
				long sum = 0;
				Collections.sort(strength[i]);
				for (int x: strength[i]) {
					sum += x;
					pfs[i].add(sum);
				}
				ans += pfs[i].get(pfs[i].size() - 1);
				indices.add(new Pair(i, pfs[i].size()));
			}

			long subtract = 0;
			for (int i = 1; i <= n; i ++) {
				long temp = ans;
				
				for (Pair j: indices) {
					int mod = j.cnt % i;
					if (mod > 0) temp -= pfs[j.idx].get(mod - 1);
				}
		
				if (i != n) System.out.print((temp - subtract) + " ");
				else System.out.println(temp - subtract);
				
				while (!indices.isEmpty() && i == indices.peek().cnt) {
					subtract += pfs[indices.peek().idx].get(pfs[indices.poll().idx].size() - 1);
				}
			}
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
