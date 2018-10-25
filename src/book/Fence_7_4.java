package book;

public class Fence_7_4 extends CommonExample
{
	private int[] height;
	
	@Override
	protected void initProperty()
	{
		int n = keyboard.nextInt();
		
		height = new int[n];
		for (int i = 0; i < n; i++) {
			height[i] = keyboard.nextInt();
		}
	}
	
	@Override
	protected void solve() 
	{
		int result = 0;
		for (int i = 0; i < height.length; i++) {
			result = Math.max(result, height[i] * getWidth(i));			
		}
		stringBuilder.append(result + "\n");
	}	
	
	private int getWidth(int index)
	{
		int lowIndex = index - 1;
		int highIndex = index + 1;
		
		for (int i = highIndex; i < height.length; i++) {
			if (height[i] < height[index]) {
				highIndex = i - 1;
				break;
			}
		}
		
		for (int i = lowIndex; i >= 0; i--) {
			if (height[i] < height[index]) {
				lowIndex = i + 1;
				break;
			}
		}
		
		return highIndex - lowIndex + 1;
	}
}