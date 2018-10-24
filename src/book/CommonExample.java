package book;

public class CommonExample 
{
	protected StringBuilder stringBuilder;
	protected Keyboard keyboard;
	
	public CommonExample() 
	{
		stringBuilder = new StringBuilder();
		keyboard = new Keyboard();
		keyboard.init();				
	}
	
	public void process() 
	{
		int n = keyboard.nextInt();
		
		for (int i = 0; i < n; i++) {
			initProperty();
			solve();			
		}
		System.out.println(stringBuilder.toString());
	}
	
	protected void initProperty() {}
	
	protected void solve() {}	
}