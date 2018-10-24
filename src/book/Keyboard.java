package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Keyboard {
	private static BufferedReader br;
	private static StringTokenizer st;

	public void init() {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer("");
	}

	public String readLine() {
		try {
			return br.readLine();
		} catch (IOException e) {
		}
		return null;
	}

	public String readLineReplace() {
		try {
			return br.readLine().replaceAll("\\s+", "");
		} catch (IOException e) {
		}
		return null;
	}

	public String next() {
		while (!st.hasMoreTokens()) {
			try {
				st = new StringTokenizer(br.readLine());
			} catch (IOException e) {
			}
		}
		return st.nextToken();
	}

	public long nextLong() {
		return Long.parseLong(next());
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}

	public double nextDouble() {
		return Double.parseDouble(next());
	}
}	