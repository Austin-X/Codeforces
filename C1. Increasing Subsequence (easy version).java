import java.io.*;
import java.util.*;

public class IncreasingSubsequenceEasyVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int n = readInt();
		Stack<Integer> s = new Stack<Integer>(); Stack<Character> moves = new Stack<Character>();
		int[] arr = new int[n];
		for (int i = 0; i < n; i ++) arr[i] = readInt();
		int low = 0, high = n - 1;
		while (low <= high) {
			if (s.isEmpty()) {
				if (arr[low] <= arr[high]) { moves.add('L'); s.push(arr[low]); low ++; }
				else { moves.add('R'); s.push(arr[high]); high --; }
			}
			else if (Math.max(arr[low], arr[high]) > s.peek()) {
				if (arr[low] > s.peek() && arr[high] > s.peek()) {
					if (arr[low] <= arr[high]) { moves.add('L'); s.push(arr[low]); low ++; }
					else { moves.add('R'); s.push(arr[high]); high --; }
				} else if (arr[low] > s.peek()) { moves.add('L'); s.push(arr[low]); low ++; }
				else { moves.add('R'); s.push(arr[high]); high --; }
			} else break;
		}
		System.out.println(s.size());
		for (char x : moves) System.out.print(x);
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
