import java.util.*;
class Mydate
{
	private int dd;
	private int mm;
	private int yyyy;
	int[] DayInMonth={30,31,30,31,30,31,30,31,31,30,31,30,31};
	public void SetDate(int d,int m,int y)
	{
		boolean valid=isvalid(d,m,y);
		if(valid)
		{
			day=d;
			month=m;
			year=y;
		}
		else
		{
			throw new RuntimeException("invalid date format");
		}	
	}
	private boolean isvalid(int d,int m,int y)
	{
		setleapyearday(y);
		if(m<1||m>12)
		{
			return false;
		}
		else if(d<1||d>DayInMonth[m])
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	private void setleapyearday(int y)
	{
		boolean isleapyear;
		if(y%400==0)
		{
			isleapyear=true;
		}
		else if(y%100==0)
		{
			isleapyear=true;
		}
		else if(y%4==0)
		{
			isleapyear=true;
		}
		else
		{
			isleapyear=false;
		}
		if(isleapyear)
		{
			DayInMonth[2]=29;
		}
		else
		{
			DayInMonth[2]=28;
		}
	}
	String dateformat()
	{
		return day+"-"+month+"-"+year;
	}
}
class Calendar
{
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		System.out.println("enter the day:");
		int d=in.nextInt();
		System.out.println("enter the month:");
		int m=in.nextInt();
		System.out.println("enter the year:");
		int y=in.nextInt();
		Mydate today=new Mydate();
		today.SetDate(d,m,y);
		System.out.println("Input date:"+today.dateformat());
	}
}
