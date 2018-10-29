package book;

import java.util.Arrays;

public class WildCard_8_2 extends CommonExample
{
	private String[] wildCardPart;
	private String[] words;
	
	@Override
	protected void initProperty()
	{
		String wildCard = keyboard.next();
		words = new String[keyboard.nextInt()];
		for (int i = 0; i < words.length; i++) {
			words[i] = keyboard.next();
		}
		
		wildCard = wildCard.replace("*", "!*!");		
		wildCardPart = wildCard.split("!");
		stringBuilder.append(Arrays.toString(wildCardPart) + "\n");
	}
	
	@Override
	protected void solve() 
	{		
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < wildCardPart.length; j++) {
				if (wildCardPart[j].isEmpty()) continue;
				
				if (wildCardPart[j] == "*") {
					
					
					
				}
			}		
			
		}

		stringBuilder.append("" + "\n");
	}	
}