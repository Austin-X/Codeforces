import java.io.*;
import java.util.*;

public class NearestBeautifulNumberEasyVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static TreeSet<Integer> two;
	public static void main(String[] args) throws IOException {
		TreeSet<Integer> one = new TreeSet<Integer>();
		two = new TreeSet<Integer>();
		
		for (int i = 1; i <= 9; i ++) {
			String s = "";
			for (int j = 1; j <= 9; j ++) {
				s += i;
				one.add(Integer.parseInt(s));
			}
		}
		one.add(1111111111);
		for (int i = 0; i <= 9; i ++) 
			for (int j = i + 1; j <= 9; j ++) 
				compute("", i, j);
		
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt(), k = readInt();
			if (k == 1) System.out.println(one.ceiling(n));
			else System.out.println(two.ceiling(n));
		}
	}
	
	static void compute(String s, int a, int b) {
		if (s.length() > 10) return;
		if (s.length() != 0 && Long.parseLong(s) <= Integer.MAX_VALUE) two.add(Integer.parseInt(s));
		if (s.length() > 0 || s.length() == 0 && a != 0) compute(s + a, a, b);
		compute(s + b, a, b);
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
