/*
 * @author DanfengWang

 * @version Oct.3 2016
 */
import java.util.Comparator;
 //sorting the order of the appointments in the list
public class StartTimeComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		Cappointment a= (Cappointment)  o1;
		Cappointment b= (Cappointment)  o2;
		// TODO Auto-generated method stub
		return a.getStartTime().compareTo(b.getStartTime());
	}
	
	
}
