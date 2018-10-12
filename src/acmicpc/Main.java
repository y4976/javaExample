//시험 복붙용 기본 폼
//keyboard 출처 : hotehrud/acmicpc github

package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main 
{
	private static StringBuilder stringBuilder;
	
	private static void initProperty()
	{
		
	}
	
	private static void process() 
	{
		stringBuilder.append("value" + "\n");
	}
	
	public static void main(String args[]) 
	{
		stringBuilder = new StringBuilder();
		keyboard.init();		
		int n = keyboard.nextInt();
		
		for (int i = 0; i < n; i++) {
			initProperty();
			process();
			System.out.println(stringBuilder.toString());
		}
	}
	
	static class keyboard {
		private static BufferedReader br;
		private static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
			}
			return null;
		}

		static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (IOException e) {
			}
			return null;
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
				}
			}
			return st.nextToken();
		}

		static long nextLong() {
			return Long.parseLong(next());
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

		static double nextDouble() {
			return Double.parseDouble(next());
		}
	}	
}