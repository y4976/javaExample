package book;

public class BoardCorver_6_5 extends CommonExample
{
	private int height;
	private int width;	
	private boolean[][] isVisited;
	private int possibleCount;
	
	private int[][] dx = {{0, 1}, {0, 1}, {1, 1}, {1, 1}};
	private int[][] dy = {{1, 0}, {1, 1}, {0, -1}, {0, 1}};
	
	@Override
	protected void initProperty()
	{
		height = keyboard.nextInt();
		width = keyboard.nextInt();
		possibleCount = 0;
		
		isVisited = new boolean[height][width];
		for (int i = 0; i < height; i++) {
			String line = keyboard.next();
			for (int j = 0; j < line.length(); j++) {
				if (line.charAt(j) == '#') {
					isVisited[i][j] = true;					
				} else {
					isVisited[i][j] = false;
					possibleCount++;
				}
			}
		}
	}
	
	@Override
	protected void solve() 
	{
		if (possibleCount % 3 == 0) {
			int[] firstIndex = getFirstIndex();	
			stringBuilder.append(dfs(firstIndex[0], firstIndex[1]) + "\n");			
		} else {
			stringBuilder.append(0 + "\n");			
		}
	}
	
	private int dfs(int x, int y) 
	{
		if (x == -1 && y == -1) {
			return 1;
		}
				
		int result = 0;		
		int[] nextIndex;
				
		for (int i = 0; i < dx.length; i++) {
			int dx0 = x + dx[i][0];
			int dx1 = x + dx[i][1];
			int dy0 = y + dy[i][0];
			int dy1 = y + dy[i][1];
						
			if (isValidIndex(dx0, dy0) && isValidIndex(dx1, dy1)) {
				if ((!isVisited[dx0][dy0]) && (!isVisited[dx1][dy1])) {
					isVisited[x][y] = isVisited[dx0][dy0] = isVisited[dx1][dy1] = true;					
					nextIndex = getFirstIndex();
					result += dfs(nextIndex[0], nextIndex[1]);
					isVisited[x][y] = isVisited[dx0][dy0] = isVisited[dx1][dy1] = false;
				}
			}		
		}
		
		return result;
	}
	
	private int[] getFirstIndex()
	{
		int[] result = {-1, -1};
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (!isVisited[i][j]) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}				
		return result;
	}
	
	private boolean isValidIndex(int x, int y)
	{
		return (0 <= x && 0 <= y && x <= height - 1 && y <= width - 1);
	}	
}