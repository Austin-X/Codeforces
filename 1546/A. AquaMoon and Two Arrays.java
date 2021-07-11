import java.io.*;
import java.util.*;

public class AquamoonAndTwoArrays {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static PrintWriter out = new PrintWriter(System.out);
	
	static class Pair {
		int idx, diff;
		Pair (int i, int d) { idx = i; diff = d; }
	}
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			int n = readInt();
			int[] a = new int[n], b = new int[n];
			int sumA = 0, sumB = 0;
			
			ArrayList<Pair> above = new ArrayList<Pair>();
			Stack<Pair> below = new Stack<Pair>();
			for (int i = 0; i < n; i ++) { a[i] = readInt(); sumA += a[i]; }
			for (int i = 0; i < n; i ++) { 
				b[i] = readInt(); 
				sumB += b[i]; 
				if (a[i] > b[i]) above.add(new Pair(i + 1, a[i] - b[i]));
				else if (a[i] < b[i]) below.push(new Pair(i + 1, b[i] - a[i]));
			}

			if (sumA != sumB) System.out.println(-1);
			else {
				ArrayList<Integer> res = new ArrayList<Integer>();
				for (Pair p: above) {
					int d = p.diff;
					while (d > 0) {
						if (below.peek().diff <= d) {
							for (int i = 0; i < below.peek().diff; i ++) { res.add(p.idx); res.add(below.peek().idx); }
							d -= below.pop().diff;
						} else {
							for (int i = 0; i < d; i ++) { res.add(p.idx); res.add(below.peek().idx); }
							Pair temp = new Pair(below.peek().idx, below.peek().diff - d);
							d = 0;
							below.pop();
							below.push(temp);
						}
					}
				}
				System.out.println(res.size() / 2);
				for (int i = 0; i < res.size(); i += 2) System.out.println(res.get(i) + " " + res.get(i + 1));
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
