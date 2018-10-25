package book;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

public class QuadTree_7_2 extends CommonExample
{
	private String input;
	private CharacterIterator it;
	
	@Override
	protected void initProperty()
	{
		input = keyboard.next();		
		it = new StringCharacterIterator(input);
	}
	
	@Override
	protected void solve() 
	{
		stringBuilder.append(reverse() + "\n");
	}
	
	private String reverse()
	{
		char now = it.current();
		it.next();
		
		if (now == 'b' || now == 'w') {
			return String.valueOf(now);
		}
		
		String[] part = new String[4];
		
		for (int i = 0; i < part.length; i++) {
			part[i] = reverse();	
		}
		
		return "x" + part[2] + part[3] + part[0] + part[1];
	}
	
}