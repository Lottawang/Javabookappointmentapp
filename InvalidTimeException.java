/*
 * @author DanfengWang

 * @version Oct.3 2016
 */

public class InvalidTimeException extends Exception {
	private int hour;
	private int minute;
	
	public void InvalidTimeException(int hour, int minute) {

		this.hour = hour;
		this.minute = minute;

	}

	public String getMessage() {

		return "Invalid time, hour must between 0 and 23";

	}

}
