import java.io.*;
import java.util.*;

public class PhoenixAndGold {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = readInt();
		for (int t = 0; t < T; t ++) {
			int n = readInt(), x = readInt();
			PriorityQueue<Integer> q = new PriorityQueue<Integer>();
			for (int i = 0; i < n; i ++) q.add(readInt());
			int sum = 0;
			boolean flag = true;
			ArrayList<Integer> ans = new ArrayList<Integer>();
			while (!q.isEmpty()) {
				if (sum + q.peek() == x) {
					int temp = q.poll();
					if (q.isEmpty()) {
						flag = false;
						break;
					} else {
						sum += q.peek();
						ans.add(q.poll());
						q.add(temp);
					}
				} else {
					sum += q.peek();
					ans.add(q.poll());
				}
			}
			
			if (!flag) System.out.println("NO");
			else {
				System.out.println("YES");
				for (int i = 0; i < ans.size() - 1; i ++) System.out.print(ans.get(i) + " ");
				System.out.println(ans.get(ans.size() - 1));
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
