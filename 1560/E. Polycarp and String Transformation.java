import java.io.*;
import java.util.*;

public class PolycarpAndStringTransformation {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int T = readInt();
		
		outer: while (T-- > 0) {
			String t = readLine();
			int[] freq = new int[26], need = new int[26];
			
			LinkedList<Character> order = new LinkedList<Character>();
			Stack<Character> ans = new Stack<Character>();
			for (int i = t.length() - 1; i >= 0; i --) {
				if (freq[t.charAt(i) - 'a'] == 0) { order.add(t.charAt(i)); ans.push(t.charAt(i)); }
				freq[t.charAt(i) - 'a'] ++;
			}
			int distinct = order.size(), idx = t.length() - 1, prevIdx = 0;
			boolean[] vis = new boolean[26];
			
			String prev = "";
			for (int i = distinct; i >= 1; i --) {
				prevIdx = idx;
				char cur = order.poll();
				vis[cur - 'a'] = true;
				if (freq[cur - 'a'] % i != 0) { System.out.println(-1); continue outer; }
				
				int target = freq[cur - 'a'] / i;
				need[cur - 'a'] = target;
				
				int[] temp = new int[26];
				while (idx >= 0) {
					temp[t.charAt(idx) - 'a'] ++;
					idx --;
					if (idx == -1 || Arrays.equals(temp, need) || !vis[t.charAt(idx) - 'a']) break;
				}
				if (!Arrays.equals(temp, need)) { System.out.println(-1); continue outer; }

				int pIdx = 0;
				if (i != distinct) {
					for (int j = idx + 1; j <= prevIdx; j ++) {
						if (t.charAt(j) == cur) continue;
						if (t.charAt(j) != prev.charAt(pIdx)) { System.out.println(-1); continue outer; }
						pIdx ++;
					}
				}
				prev = t.substring(idx + 1, prevIdx + 1);
			}
			System.out.print(t.substring(0, prevIdx + 1) + " ");
			while (!ans.isEmpty()) System.out.print(ans.pop());
			System.out.println();
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
