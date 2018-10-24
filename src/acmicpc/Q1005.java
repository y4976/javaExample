//indegree study... 
//나중에 한번 더 풀어 볼 것.
//시험 복붙용 기본 폼
//re practice

package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1005 
{
	private static StringBuilder stringBuilder;
	
	private static int[] dp;
	private static int[] time;	
	private static int n, edgeCount;	
	
	private static int[] indegree;
	private static boolean[][] map;
	private static int targetVertex;
	
	private static void initProperty()
	{		
		n = keyboard.nextInt();
		edgeCount = keyboard.nextInt();
								
		time = new int[n];
		dp = new int[n];
		
		map = new boolean[n][n];
		
		indegree = new int[n];
					
		for (int j = 0; j < n; j++) {
			time[j] = keyboard.nextInt();
		}
		
		for (int j = 0; j < edgeCount; j++) {
			int from = keyboard.nextInt() - 1;
			int to = keyboard.nextInt() - 1;
			map[from][to] = true;
			indegree[to]++;
		}		
	}
	
	private static void process() 
	{	
		Queue<Integer> q = new LinkedList<Integer>();
		for (int j = 0; j < n; j++) {
			if (indegree[j] == 0) {
				dp[j] = time[j];
				q.add(j);
			}
		}			
		
		while (!q.isEmpty()) {
			int v = q.poll();
			for (int j = 0; j < n; j++) {
				if (map[v][j]) {
					dp[j] = Math.max(dp[j], dp[v] + time[j]);
					if (--indegree[j] == 0) {
						q.add(j);
					}
				}
			}
		}	
					
		targetVertex = keyboard.nextInt() - 1;
		
		stringBuilder.append(dp[targetVertex] + "\n");
	}
	
	public static void main(String args[]) 
	{
		stringBuilder = new StringBuilder();
		keyboard.init();		
		int n = keyboard.nextInt();
		
		for (int i = 0; i < n; i++) {
			initProperty();
			process();			
		}
		System.out.println(stringBuilder.toString());
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
