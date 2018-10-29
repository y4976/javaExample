package book;

public class PI_8_7 extends CommonExample
{	
	private static final int INF = 987654321;
	private String input;
	private int[] dp;
	
	@Override
	protected void initProperty()
	{
		input = keyboard.next();
		dp = new int[input.length()];
		for (int i = 0; i < input.length(); i++) {			
			dp[i] = INF;
		}
	}
	
	@Override
	protected void solve() 
	{	
		int min = getMinValue(0);
		
		stringBuilder.append(min + "\n");
	}	
	
	private int getMinValue(int index)
	{	
		if (index == input.length()) return 0;
		
		if (dp[index] != INF) return dp[index];
		
		int result = dp[index];
		for (int i = 3; i <= 5; i++) {			
			if (index + i <= input.length()) {				
				result = Math.min(result, getDifficulty(input.substring(index, index + i)) + getMinValue(index + i));
			}
		}
		dp[index] = result;
		return result;
	}
	
	private int getDifficulty(String source)
	{
		int[] temp = new int[source.length()];
		
		for (int i = 0; i < temp.length; i++) {
			temp[i] = source.charAt(i);
		}

		boolean d1, d2, d3, d4;
		d1 = d2 = d3 = d4 = true;
		
		for (int i = 2; i < temp.length; i++) {
			d1 &= (temp[i-2] == temp[i-1]) && (temp[i-1] == temp[i]);
			d2 &= (temp[i-2] + 2 == temp[i-1] + 1) && (temp[i-2] + 2 == temp[i]) ||
				  (temp[i-2] - 2 == temp[i-1] - 1) && (temp[i-2] - 2 == temp[i]);
			d3 &= temp[i-2] == temp[i];
			d4 &= temp[i-2] - temp[i-1] == temp[i-1] - temp[i];			
		}
		
		if (d1) return 1;
		if (d2) return 2;
		if (d3) return 4;
		if (d4) return 5;
		return 10;
	}
}