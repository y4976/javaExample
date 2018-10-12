package acmicpc;

import java.util.Scanner;

public class Q1004 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
			
		int[] result = new int[t];		
		
		for (int i = 0; i < t; i++) {
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int endX = sc.nextInt();
			int endY = sc.nextInt();					
			
			int planetCount = sc.nextInt();
												
			for (int j = 0; j < planetCount; j++) {
				int planetX = sc.nextInt();
				int planetY = sc.nextInt();
				int planetR = sc.nextInt();
				
				if (inside(startX, planetX, startY, planetY, planetR) != inside(endX, planetX, endY, planetY, planetR)) {
					result[i]++;
				}
			}
			
			System.out.println(result[i]);
		}
		
		sc.close();		
	}
	
	private static boolean inside(int x1, int x2, int y1, int y2, int r)
	{
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r * r; 
	}
}
