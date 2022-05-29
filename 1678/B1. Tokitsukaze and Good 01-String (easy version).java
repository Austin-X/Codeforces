import java.io.*;
import java.util.*;

public class TokitsukazeAndGood01StringEasyVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			String str = readLine();
			int[] s = new int[n];
			for (int i = 0; i < n; i ++) s[i] = Character.getNumericValue(str.charAt(i));
			
			ArrayList<Integer> segments = new ArrayList<Integer>();
			int cur = s[0], len = 1;
			for (int i = 1; i < n; i ++) {
				if (s[i] != cur) {
					segments.add(len);
					len = 1;
					cur = s[i];
				} else len ++;
			}
			segments.add(len);
			
			int ans = 0;
			boolean odd = false;
			for (int i = 0; i < segments.size(); i ++) {
				if (!odd) {
					if (segments.get(i) % 2 == 1) { odd = true; }
				} else {
					if (segments.get(i) % 2 == 1) { odd = false; ans ++; }
					else ans ++;
				}
			}
			System.out.println(ans);
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
