package acmicpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1006 
{
	private static StringBuilder stringBuilder;
	
	private static int districtCount;
	private static int armyCount;
	private static int[] cost;
	
	private static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	private static ArrayList<Integer> maxCoupleCount = new ArrayList<Integer>();
	private static ArrayList<Integer> g = new ArrayList<Integer>();
	private static ArrayList<Integer> dp = new ArrayList<Integer>();
	private static boolean[] dupVertex;	
		
	private static void initProperty()
	{
		districtCount = keyboard.nextInt();
		armyCount = keyboard.nextInt();
		cost = new int[districtCount * 2];
		dupVertex = new boolean[districtCount * 2];
		adj.clear();
		maxCoupleCount.clear();
				
		for (int i = 0; i < cost.length; i++) {
			cost[i] = keyboard.nextInt();
		}
				
		for (int i = 0; i < districtCount * 2; i++) {
			adj.add(new ArrayList<Integer>());
			
			int[] neighborIndexes = getNeighborIndexes(i);
			
			for (int j : neighborIndexes) {
				if (cost[i] + cost[j] <= armyCount) {
					adj.get(i).add(j);
				}					
			}
		}
	}
	
	private static void process() 
	{		
		ArrayList<Queue<Integer>> adj2 = new ArrayList<Queue<Integer>>();
		
		for (int j = 0; j < adj.size(); j++) {
			adj2.add(new LinkedList<Integer>());
			for (int k = 0; k < adj.get(j).size(); k++) {
				adj2.get(j).add(adj.get(j).get(k));
			}
		}				
		
		int coupleCount = 0;
		for (int i = 0; i < adj2.size(); i++) {
			if (adj2.get(i).isEmpty()) continue;
			
			Queue<Integer> q = new LinkedList<Integer>();			
			
			g.clear();
			dp.clear();
			q.add(i);
			g.add(i);
			while(!q.isEmpty()) {
				int now = q.poll();
				
				while(!adj2.get(now).isEmpty()) {
					int temp = adj2.get(now).poll();
					
					if (!g.contains(temp)) {
						q.add(temp);
						g.add(temp);
					}										
				}				
			}
			
			for (int j = 0; j < adj.size(); j++) {
				dp.add(0);
			}
			
//			int temp = dfs(g.get(0));
//			coupleCount += temp;
//						
//			stringBuilder.append(String.valueOf(temp) + "\n");
//			stringBuilder.append(dp.toString() + "\n");
			stringBuilder.append(g.toString() + "\n");
			stringBuilder.append("\n");
		}
		
		stringBuilder.append(String.valueOf(districtCount * 2 - coupleCount) + "\n");
		stringBuilder.append("\n");
		
		for (int i = 0; i < adj.size(); i++) {
			stringBuilder.append(String.valueOf(i) + " : " + adj.get(i).toString() + "\n");	
		}
	}
	
	private static int dfs(int vertex)
	{	
		if (vertex == g.get(g.size() - 1)) {
			return 0;
		}
		
		if (dp.get(vertex) != 0) {
			return dp.get(vertex);
		}
		
		int max = dp.get(vertex);
		
		if (adj.get(vertex).size() == 3) {
			
		} else {
			for (int i = 0; i < adj.get(vertex).size(); i++) {		
				if (dupVertex[adj.get(vertex).get(i)]) continue;
				dupVertex[adj.get(vertex).get(i)] = true;
				max = Math.max(max, dfs(adj.get(vertex).get(i)));
				
				int nextVertex = adj.get(vertex).get(i);
				
				for (int j = 0; j < adj.get(nextVertex).size(); j++) {
					if (dupVertex[adj.get(nextVertex).get(j)]) continue;
					dupVertex[adj.get(nextVertex).get(j)] = true;
	
					max = Math.max(max, 1 + dfs(adj.get(nextVertex).get(j)));
					 
					dupVertex[adj.get(nextVertex).get(j)] = false;
				}
					
				dupVertex[adj.get(vertex).get(i)] = false;
			}		
		}
		
		dp.set(vertex, max);
		return max;
	}
	
//	private static int dfs(int index)
//	{	
//		if (index >= g.size() - 1) {
//			return 0;
//		}
//		
//		if (dp.get(index) != 0) {
//			return dp.get(index);
//		}
//		
//		int max = dp.get(index);
//		
////		for (int i = 0; i < adj.get(g.get(index)).size(); i++) {
////			for (int j = 0; j < g.size(); j++) {
////				if (g.get(j) == adj.get(g.get(index)).get(i)) {
////					max = Math.max(max, dfs(j));
////				}				
////			}			
////		}
//		
//		//자기 x
//		if (isConnect(g.get(index), g.get(index + 1))) {
//			max = Math.max(max, dfs(index + 1));
//		} 
//		//자기 x		
//		if (index + 2 < g.size() - 1 && isConnect(g.get(index), g.get(index + 2))) {
//			max = Math.max(max, dfs(index + 2));
//		}
//		
//		if (adj.get(g.get(index + 1)).size() > 2) {
//			int count = 0;
//			for (int i = 0; i < adj.get(g.get(index + 1)).size(); i++) {
//				if (adj.get(g.get(index + 1)).get(i) == index) continue;
//
//				// 자기 x				
//				max = Math.max(max, 1 + dfs(index + 1 + count));
//				count++;
//			}
//		} else {
//			// 자기 x			
//			max = Math.max(max, 1 + dfs(index + 2));
//		}
//		
////		for (int i = 0; i < adj.get(g.get(index + 1)).size(); i++) {
////			if (adj.get(g.get(index + 1)).get(i) == index) continue;
////		}
//		
//		dp.set(index, max);
//		return max;
//	}
		
	
	private static boolean isConnect(int vertex1, int vertex2)
	{
		for (int i = 0; i < adj.get(vertex1).size(); i++) {
			if (adj.get(vertex1).get(i) == vertex2) {
				return true;
			}
		}
		return false;
	}
	
	private static int[] getNeighborIndexes(int index)
	{
		int[] result = new int[3];
				
		if (index == 0) {
			result[0] = districtCount - 1;
		} else if (index == districtCount) {
			result[0] = districtCount * 2 - 1;
		} else {
			result[0] = index - 1;
		}
					
		if (index == districtCount - 1) {
			result[1] = 0;
		} else if (index == districtCount * 2 - 1) {
			result[1] = districtCount;
		} else {
			result[1] = index + 1;
		}
		
		if (index >= districtCount) {
			result[2] = index - districtCount;	
		} else {
			result[2] = index + districtCount;
		}
		
		
		return result;		
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