import java.util.StringTokenizer;
/*
 * @author DanfengWang
 * @version Oct.3 2016
 */

public class Cappointment {
	
	private String startTime;
	private String endTime;
	public String description;
	
//to check the time  by using the tokenizer and change the hour, minute to integer type to see the time is valid or not.	
	public boolean isValidAppointment(String startTime, String endTime)
	{
		int startHour= 0;
		int startMinute = 0;
		int endHour=0;
		int endMinute=0;
		StringTokenizer st = new StringTokenizer(startTime,": ");
		if(st.hasMoreTokens()){
			startHour = Integer.parseInt(st.nextToken());
		}
		if(st.hasMoreTokens()){
			startMinute = Integer.parseInt(st.nextToken());	
		}
		StringTokenizer st1 = new StringTokenizer(endTime,": ");
		if(st1.hasMoreTokens()){
			endHour = Integer.parseInt(st1.nextToken());
		}
		if(st1.hasMoreTokens()){
			endMinute = Integer.parseInt(st1.nextToken());	
		}
		if (startHour<endHour){
		  return true;
		}else if(startHour == endHour && startMinute< endMinute){
			return true;
		}else {
			System.out.println("invalid appointment, check start/end times.");
		return false;
		}
	}
	
	
	public String getStartTime()
	{
		return startTime;
	}
	
	public void setStartTime(String startTime){
		this.startTime = startTime;
	}
	
	public String getEndTime()
	{
		return endTime;
	}
	
	public void setEndTime(String endTime){
		this.endTime = endTime;
	}
	
	public String getDescription(){
		return description;
	}
	public void setDescription(String description){
		this.description = description;
	}

	public String toString()
	{
		return "Start:" + startTime + ", end: " + endTime+ "Content: " + description;
	}
	
}
