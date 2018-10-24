package book;

import java.util.*;

public class ClockSync_6_8 extends CommonExample
{	
	private int[][] button = 
		{
			{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,0},
			{0,0,0,0,1,0,0,0,0,0,1,0,0,0,1,1},
			{1,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,1,1,0,1,0,1,0,0,0},
			{1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1},
			{0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1},
			{0,0,0,0,1,1,0,1,0,0,0,0,0,0,1,1},
			{0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,0,0,0,1,0,0,0,1,0,0}
		};
						
	
	private int[] clock = new int[16];
	private int[] pushCount = new int[16];
	private ArrayList<Integer> resultSet;
	
	@Override
	protected void initProperty()
	{
		resultSet = new ArrayList<Integer>();
		for (int i = 0; i < 16; i++) {
			clock[i] = (int) (keyboard.nextInt()/3);
		}		
	}
	
	@Override
	protected void solve() 
	{	
		pushButton(0, 0);
		
		stringBuilder.append(Collections.min(resultSet) + "\n");
	}		
	
	private void pushButton(int index, int depth)
	{
		if (isSync()) {
			resultSet.add(depth);
		}			
				
		for (int i = index; i < button.length; i++) {
			if (pushCount[i] > 3) continue;
						
			pushCount[i]++;
			for (int j = 0; j < 16; j++) {
				clock[j] += button[i][j]; 
			}
			
			pushButton(i, depth + 1);
			
			for (int j = 0; j < 16; j++) {
				clock[j] -= button[i][j]; 
			}		
			pushCount[i]--;
		}
	}
	
	private boolean isSync()
	{
		for (int i = 0; i < clock.length; i++) {
			if (clock[i] % 4 > 0) {
				return false;
			}
		}
		return true;
	}
}
