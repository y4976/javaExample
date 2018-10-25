package book;

import java.util.*;

public class FanMeeting_7_6 extends CommonExample
{
	private ArrayList<Integer> manIdol = new ArrayList<Integer>();
	private String idol;
	private String fan;
	
	@Override
	protected void initProperty()
	{
		manIdol.clear();
		idol = keyboard.next();
		fan = keyboard.next();
		
		for (int i = 0; i < idol.length(); i++) {
			if (idol.charAt(i) == 'M') {
				manIdol.add(i);
			}
		}
	}
	
	@Override
	protected void solve() 
	{		
		int count = fan.length() - idol.length() + 1;
		int fail = 0;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < manIdol.size(); j++) {
				if (fan.charAt(i + manIdol.get(j)) == 'M') {
					fail++;
					break;
					
				}
			}
		}
		stringBuilder.append((count - fail) + "\n");
	}
}