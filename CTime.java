/*
 * @author DanfengWang
 * @STUDENT ID:104489084
 * @version Oct.3 2016
 */
import java.util.StringTokenizer;

public class CTime {
	
	private int hour;    // 0-23
	private int minute;	// 0-59	
//to make sure the hour is between 0 and 23, the minute is between 0 and 59
    public static boolean setTime (String hhmm) throws InvalidTimeException 
    {
    	int hour=0, minute=0;
    	StringTokenizer st = new StringTokenizer(hhmm,": ");
    	if (st.hasMoreTokens()){
    		hour = Integer.parseInt(st.nextToken());	
    	}
    	if (st.hasMoreTokens()){
    		minute = Integer.parseInt(st.nextToken());
    	}
    	 if(isValidHour(hour) && (isValidMinute(minute))){
    		  return true;
    	 }else if( isValidHour(hour)==false){
    		 System.out.println("invalid time, hour must be between 0 and 23");
    		 
    	 }else if (isValidMinute(minute)==false){
    		 System.out.println("invalid time, minute must be between 0 and 59");	 
    	 }
  		return false;
    }
	
	private static boolean isValidHour(int hour)
	{
		return ((hour >= 0 && hour <= 23));
				
	}
	
	private static boolean isValidMinute(int minute){
		return (minute >= 0 && minute <= 59);
	}
    
		
	
	public int getHour()
	{
		return hour;
	}
	public int getMinute()
	{
		return minute;
	}
	public String toString()
	{
		return "\""+hour + ":" + minute+"\"";
	}
}
