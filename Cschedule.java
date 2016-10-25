/*
 * @author DanfengWang
 * @STUDENT ID:104489084
 * @version Oct.3 2016
 */
import java.util.*;

public class Cschedule {
//create appointment list to store the appointment
	 private static List<Cappointment> cappointmentList = new ArrayList<>();
	 
	 public List<Cappointment> getCappointmentList(){
		 
		return cappointmentList;
	 }
// to add the appointment	 
	 public void setCappointment(Cappointment cappointment){
		 
		 this.cappointmentList.add(cappointment);
	 }
}
