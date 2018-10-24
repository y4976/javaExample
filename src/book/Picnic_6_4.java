package book;

public class Picnic_6_4 extends CommonExample
{
	private int friendCount;
	
	private boolean[][] couple;
	private boolean[] isVisit;
		    
	@Override
	protected void initProperty()
	{
		friendCount = keyboard.nextInt();
		int coupleCount = keyboard.nextInt();
		
		couple = new boolean[friendCount][friendCount];
		isVisit = new boolean[friendCount];
		
		for (int i = 0; i < coupleCount; i++) {
			int friend1 = keyboard.nextInt();
			int friend2 = keyboard.nextInt();
			
			couple[friend1][friend2] = true;
			couple[friend2][friend1] = true;			
		}
	}
	
	@Override
	protected void solve() 
	{
		stringBuilder.append(dfs(0) + "\n");
	}	
	
	private int dfs(int index)
	{			
		if (index == -1) {
			return 1;
		}
		
		int result = 0;
		
		for (int i = index + 1; i < friendCount; i++) {
			if (isVisit[i]) continue;
			
			if (couple[index][i]) {
				isVisit[index] = isVisit[i] = true;
				result += dfs(getNotVisitedIndex());
				isVisit[index] = isVisit[i] = false;
			}
		}
		
		return result;
	}
	
	private int getNotVisitedIndex()
	{
		for (int i = 0; i < friendCount; i++) {
			if (!isVisit[i]) {
				return i;
			}
		}		
		return -1;
	}			
}


