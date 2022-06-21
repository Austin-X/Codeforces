import java.io.*;
import java.util.*;

public class BinaryString {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		while (t-- > 0) {
			char[] temp = readLine().toCharArray();
			int n = temp.length;
			char[] ch = new char[n + 1];
			for (int i = 1; i <= n; i ++) ch[i] = temp[i - 1];
			
			int mx = 0;
			int zeroCnt = 0, oneCnt = 0;
			int[] pfsZero = new int[n + 1], pfsOne = new int[n + 1];
			for  (int i = 1; i <= n; i ++) {
				if (ch[i] == '0') {
					zeroCnt ++;
					pfsZero[i] = pfsZero[i - 1] + 1;
					pfsOne[i] = pfsOne[i - 1];
				}
				else {
					oneCnt ++;
					pfsZero[i] = pfsZero[i - 1];
					pfsOne[i] = pfsOne[i - 1] + 1;
				}
			}
			mx = Math.min(zeroCnt, oneCnt);
			
			int l = 0, r = mx;
			while (l < r) {
				int mid = (l + r) / 2;
				if (check(mid, ch, pfsZero, pfsOne)) r = mid;
				else l = mid + 1;
			}
			
			System.out.println(l);
		}
	}
	
	static boolean check(int val, char[] ch, int[] pfsZero, int[] pfsOne) {
		ArrayList<Integer> zeros = new ArrayList<Integer>(), ones = new ArrayList<Integer>();
		int n = ch.length - 1, sections = 1;
		for (int i = 1; i <= n; i ++) {
			if (ch[i] == '0') zeros.add(i);
			else ones.add(i);
			if (i > 1 && ch[i] != ch[i - 1]) sections ++;
		}
		
		if (val == 0) {
			if (sections < 3 || sections == 3 && ch[1] == '0') return true;
			else return false;
		}

		if (zeros.size() >= val) {
			for (int i = val - 1; i < zeros.size(); i ++) {
				int val1 = i == zeros.size() - 1 ? pfsOne[n] : pfsOne[zeros.get(i + 1)], val2 = i == val - 1 ? 0 : pfsOne[zeros.get(i - val)];
				if (pfsOne[n] - val1 + val2 <= val) return true;
			}
		}
		if (ones.size() >= val) {
			if (val < ones.size() && pfsZero[n] - pfsZero[ones.get(val)] <= val) return true;
			if (val == ones.size()) return true;
			
			int f = val - 2, b = 1;
			while (f >= 0) {
				if (pfsZero[ones.get(ones.size() - b - 1)] - pfsZero[ones.get(f + 1)] <= val) return true;
				f --;
				b ++;
			}
		}
		
		return false;
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
