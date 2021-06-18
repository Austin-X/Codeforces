import java.io.*;
import java.util.*;
 
public class ChallengingCliffs {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			Integer[] h = new Integer[n];
			for (int i = 0; i < n; i ++) h[i] = readInt(); 
			Arrays.sort(h);
			
			int minDiff = Integer.MAX_VALUE, idx1 = 0, idx2 = 0;
			for (int i = 0; i < n - 1; i ++) minDiff = Math.min(minDiff, h[i + 1] - h[i]);
			for (int i = 0; i < n - 1; i ++) if (h[i + 1] - h[i] == minDiff) { idx1 = i; idx2 = i + 1; break; }
			pw.print(h[idx1] + " ");
			for (int i = idx2 + 1; i < n; i ++) pw.print(h[i] + " ");
			for (int i = 0; i < idx1; i ++) pw.print(h[i] + " ");
			pw.println(h[idx2]);
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
