import java.io.*;
import java.util.*;

public class PlayoffTournament {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int k = readInt(), n = 1 << k;
		char[] ch = new char[n];
		int[] f = new int[n], parent = new int[n];
		int[][] child = new int[n][2];
		
		String str = readLine();
		for (int i = 1; i < n; i ++) ch[i] = str.charAt(i - 1);
		for (int i = 1; i <= Math.pow(2, k - 1); i ++) f[i] = ch[i] == '?' ? 2 : 1;
		
		int cnt = k - 1;
		for (int i = 1; i < n - 1;) {
			int idx = i + (1 << cnt);
			for (int j = i; j < i + (1 << cnt); j += 2) {
				if (ch[idx] == '0') f[idx] = f[j];
				else if (ch[idx] == '1') f[idx] = f[j + 1];
				else f[idx] = f[j] + f[j + 1];
				parent[j] = idx;
				parent[j + 1] = idx;
				child[idx][0] = j;
				child[idx][1] = j + 1;
				idx ++;
			}
			i += 1 << cnt;
			cnt --;
		}
		
		int q = readInt();
		for (int t = 0; t < q; t ++) {
			int p = readInt();
			char c = readCharacter();
			
			if (c != '?') {
				if (p <= 1 << k - 1) f[p] = 1;
				else if (c == '0') f[p] = f[child[p][0]];
				else f[p] = f[child[p][1]];
			} else {
				if (p <= 1 << k - 1) f[p] = 2;
				else f[p] = f[child[p][0]] + f[child[p][1]];
			}
			ch[p] = c;
			
			int j = p;
			while (j != n - 1) {
				if (ch[parent[j]] == '0') f[parent[j]] = f[child[parent[j]][0]];
				else if (ch[parent[j]] == '1') f[parent[j]] = f[child[parent[j]][1]];
				else f[parent[j]] = f[child[parent[j]][0]] + f[child[parent[j]][1]];
				j = parent[j];
			}
			pw.println(f[n - 1]);
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
