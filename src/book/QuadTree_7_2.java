package book;

public class QuadTree_7_2 extends CommonExample
{
	private String input;
	
	@Override
	protected void initProperty()
	{
		input = keyboard.next();		
	}
	
	@Override
	protected void solve() 
	{		
		String result;
		if (input.charAt(0) == 'x') {
			result = "x" + convert(input.substring(1));
		} else {
			result = input;	
		}
		stringBuilder.append(result + "\n");
		
	}
	
	private String convert(String a)
	{
		if (a.length() == 1) {
			return a;
		}
		
		if (!hasChild(a)) {
			return a.substring(2, 4) + a.substring(0, 2);
		}
		
		int[] partCount = getPartCount(a);		
		
		String[] part = new String[4];
		
		int startIndex = 0;
		for (int i = 0; i < part.length; i++) {
			part[i] = a.substring(startIndex, startIndex + partCount[i]);	
			if (partCount[i] > 1) {
				part[i] = "x" + convert(part[i].substring(1));
			}
			startIndex += partCount[i];
		}
		
		return part[2] + part[3] + part[0] + part[1]; 
	}
	
	private boolean hasChild(String a)
	{
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == 'x') {
				return true;
			}
		}
		return false;
	}
	
	private int[] getPartCount(String a)
	{
		int[] count = new int[4];
				
		int startIndex = 0;
		
		for (int i = 0; i < 4; i++) {
			if (a.charAt(startIndex) == 'x') {
				int needCount = 5;
				for (int j = startIndex + 1; j < startIndex + needCount; j++) {
					if (a.charAt(j) == 'x') {
						needCount += 4;
					}
				}
				count[i] = needCount;
				startIndex += needCount; 
			} else {
				count[i] = 1;
				startIndex++;
			}				
		}
		
		return count;
	}
}