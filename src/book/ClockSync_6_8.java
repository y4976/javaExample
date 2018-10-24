package book;

public class ClockSync_6_8 extends CommonExample
{	
	private static final int INF = 987654321;
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
	
	@Override
	protected void initProperty()
	{
		for (int i = 0; i < 16; i++) {
			clock[i] = (int) (keyboard.nextInt()/3);
		}		
	}
	
	@Override
	protected void solve() 
	{			
		stringBuilder.append(pushButton(0) + "\n");
	}		
	
	private int pushButton(int buttonIndex)
	{
		if (buttonIndex > button.length - 1) {
			if (isSync()) {
				return 0;
			} else {	
				return INF;
			}
		}					
		
		int result = INF;
		
		for (int i = 0; i < 4; i++) {
			result = Math.min(result, i + pushButton(buttonIndex + 1));
			for (int j = 0; j < 16; j++) {
				clock[j] += button[buttonIndex][j]; 
			}
		}		
		
		return result;
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
