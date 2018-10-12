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
	private static int[] map;
	
	private static boolean[] isInput;
	private static int count;
	private static int[][] possible;
	private static int neighborCount;
	
	private static void initProperty()
	{
		districtCount = keyboard.nextInt();
		armyCount = keyboard.nextInt();
		map = new int[districtCount * 2];
		isInput = new boolean[districtCount * 2];
		count = districtCount * 2;
		possible = new int[districtCount * 2][districtCount * 2];
		neighborCount = 0;
		
		for (int i = 0; i < map.length; i++) {
			map[i] = keyboard.nextInt();
			isInput[i] = true;
		}		
	}
	
	private static void process() 
	{		
		for (int i = 0; i < map.length; i++) {
			int[] neighborIndexes = getNeighborIndexes(i);
			
			for (int j : neighborIndexes) {
				if (map[i] + map[j] <= armyCount) {
					if (possible[j][i] == 0) {
						possible[i][j] = 1;
						isInput[i] = false;
						isInput[j] = false;
						neighborCount++;	
					}					
				}
			}
		}
		
		for (int i = 0; i < possible.length; i++) {
			for (int j = 0; j < possible.length; j++) {
				if (possible[i][j] == 1) {
					
				}
			}
		}
		
//		stringBuilder.append(Arrays.toString(possible[0]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[1]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[2]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[3]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[4]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[5]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[6]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[7]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[8]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[9]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[10]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[11]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[12]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[13]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[14]) + "\n");
//		stringBuilder.append(Arrays.toString(possible[15]) + "\n");		
//		stringBuilder.append(neighborCount + "\n");
		stringBuilder.append(Arrays.toString(isInput) + "\n");		
	}
	
	private static void dfs(int index)
	{
		
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