import java.io.*;
import java.util.*;
 
public class NearestBeautifulNumberHardVersion {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		int t = readInt();
		
		outer: while (t-- > 0) {
			int n = readInt(), k = readInt();
			String s = String.valueOf(n);
			TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
			
			for (int i = 0; i < s.length(); i ++) {
				int x = Character.getNumericValue(s.charAt(i));
				if (!map.containsKey(x) && map.size() == k) {
					if (map.ceilingKey(x) == null) {
						int idx = -1, val = 0, mx = map.lastKey(), min = map.firstKey();
						for (int j = i - 1; j >= 0; j --) {
							int d = Character.getNumericValue(s.charAt(j));
							if (d != mx && j > map.get(mx)) { val = d; idx = j; break; }
						}
						if (idx == -1) {
							if (k == 1) for (int j = 0; j < s.length(); j ++) System.out.print(mx + 1);
							else {
								for (int j = 0; j < map.get(mx); j ++) System.out.print(s.charAt(j));
								System.out.print(mx + 1);
								for (int j = map.get(mx) + 1; j < s.length(); j ++) System.out.print(min);
							}
						}
						else {
							if (map.get(val) != idx) {
								for (int j = 0; j < idx; j ++) System.out.print(s.charAt(j));
								System.out.print(map.higherKey(val));
								for (int j = idx + 1; j < s.length(); j ++) System.out.print(min);
							} else {
								for (int j = 0; j < idx; j ++) System.out.print(s.charAt(j));
								System.out.print(val + 1);
								if (!map.containsKey(val + 1)) {
									if (min == val) for (int j = idx + 1; j < s.length(); j ++) System.out.print(val + 1);
									else for (int j = idx + 1; j < s.length(); j ++) System.out.print(min);
								} else {
									for (int j = idx + 1; j < s.length(); j ++) System.out.print(0);
								}
 							}
						}
					} else {
						int c = map.ceilingKey(x), min = map.firstKey();
						for (int j = 0; j < i; j ++) System.out.print(s.charAt(j));
						System.out.print(c);
						for (int j = i + 1; j < s.length(); j ++) System.out.print(min);
					}
					System.out.println();
					continue outer;
				} else if (!map.containsKey(x)) map.put(x, i);
			}
			System.out.println(n);
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
