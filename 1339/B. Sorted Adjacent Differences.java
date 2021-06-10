import java.io.*;
import java.util.*;

public class SortedAdjacentDifferences {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		for (int t = 0; t < T; t ++) {
			int n = readInt();
			int[] a = new int[n];
			for (int i = 0; i < n; i ++) a[i] = readInt();
			Arrays.parallelSort(a);
			int low, high;
			if (n % 2 == 0) { low = n / 2 - 1; high = n / 2; }
			else { low = n / 2; high = n / 2 + 1; }
			
			pw.print(a[low] + " ");
			pw.print(a[high] + " ");
			low --; high ++;

			boolean flag = false;
			while (true) {
				if (!flag) { 
					if (low == -1) break;
					pw.print(a[low] + " ");
					low --;
					flag = true;
				} else {
					if (high == n) break;
					pw.print(a[high] + " ");
					high ++;
					flag = false;
				}
			}
			pw.println();
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
