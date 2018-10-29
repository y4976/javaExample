package book;

import java.util.*;

public class Jlis_8_5 extends CommonExample
{	
	private ArrayList<Integer> a, b;	
	private ArrayList<ArrayList<Integer>> aLis, bLis;
	
	@Override
	protected void initProperty()
	{
		a = new ArrayList<Integer>();
		b = new ArrayList<Integer>();
		aLis = new ArrayList<ArrayList<Integer>>();
		bLis = new ArrayList<ArrayList<Integer>>();
				
		int countA = keyboard.nextInt();
		int countB = keyboard.nextInt();
		for (int i = 0; i < countA; i++) {
			a.add(keyboard.nextInt());
		}
		
		for (int i = 0; i < countB; i++) {
			b.add(keyboard.nextInt());
		}
	}
	
	@Override
	protected void solve() 
	{	
		convertLis(a, aLis);
		convertLis(b, bLis);		
		
		
		for (int i = 0; i < aLis.size(); i++) {
			stringBuilder.append("a" + String.valueOf(i) + aLis.get(i).toString() + "\n");	
		}
		for (int i = 0; i < bLis.size(); i++) {
			stringBuilder.append("b" + String.valueOf(i) + bLis.get(i).toString() + "\n");	
		}	
		
		stringBuilder.append("\n");	
	}	
	
	private void convertLis(ArrayList<Integer> source, ArrayList<ArrayList<Integer>> target)
	{
		while (!source.isEmpty()) {
			ArrayList<Integer> targetItem = new ArrayList<Integer>();
			
			int now = 0;
			for (int i = 0; i < source.size(); i++) {
				int value = source.get(i); 
				if (now < value) {
					now = value;
					targetItem.add(value);
					source.set(i, -1);
				}
			}
			
			for (int i = source.size() - 1; i >= 0; i--) {
				if (source.get(i) == -1) {
					source.remove(i);
				}
			}
			
			target.add(targetItem);
		}		
	}
}