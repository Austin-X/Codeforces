import java.io.*;
import java.util.*;

public class FairPlayoff {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter pw = new PrintWriter(System.out);
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int[] arr = new int[4];
			int max1 = 0, max2 = 0;
			for (int i = 0; i < 4; i ++) {
				arr[i] = readInt();
				max1 = Math.max(max1, arr[i]);
			}
			for (int i = 0; i < 4; i ++) {
				if (arr[i] != max1) max2 = Math.max(max2, arr[i]);
			}
			int fin1 = Math.max(arr[0], arr[1]), fin2 = Math.max(arr[2], arr[3]);
			if (fin1 == max1 && fin2 == max2 || fin1 == max2 && fin2 == max1) pw.println("YES");
			else pw.println("NO");
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
