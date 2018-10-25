package book;

public class BookMain 
{	
	private static CommonExample exam;
	
	public static void main(String args[]) 
	{
//		exam = new Picnic_6_4();
//		exam = new BoardCorver_6_5();
//		exam = new ClockSync_6_8();
//		exam = new QuadTree_7_2();
//		exam = new Fence_7_4();
		exam = new FanMeeting_7_6();
		exam.process();
	}
}