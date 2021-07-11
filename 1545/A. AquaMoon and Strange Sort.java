import java.io.*;
import java.util.*;

public class AquamoonAndStrangeSort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			Integer[] a = new Integer[n];
			int[][] freq = new int[100001][2];
			for (int i = 0; i < n; i ++) { a[i] = readInt(); freq[a[i]][i % 2] ++; }
			Arrays.parallelSort(a);
			
			boolean flag = true;
			int cur = -1;
			for (int i = 0; i < n; i ++) {
				if (a[i] == cur) continue;
				cur = a[i];
				if (i % 2 == 0) {
					int works = freq[cur][0], notWorks = freq[cur][1];
					if (notWorks < works - 1 || notWorks > works) {
						flag = false;
						break;
					}
				} else {
					int works = freq[cur][1], notWorks = freq[cur][0];
					if (notWorks < works - 1 || notWorks > works) {
						flag = false;
						break;
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
