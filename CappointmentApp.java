
import java.util.Collections;
import java.util.Scanner;
/*
 * @author DanfengWang

 * @version Oct.3 2016
 */
public class CappointmentApp {

	public static void main(String[] args) throws InvalidTimeException {
		boolean select = true;
		Scanner scanner = new Scanner(System.in);
		Cschedule cschedule = new Cschedule();
		CTime ctime = new CTime();
// to show the menu
		while (select) {
			 System.out.println("");
			 System.out.println("********************************************************");
			 System.out.println("------------My Appointment Book Application------------");
			 System.out.println("********************************************************");
			 System.out.println("");
			 System.out.println("---Here are some options:");
			 System.out.println("");
			 System.out.println("1. Create a new appointment");
			 System.out.println("2. Display all appointments (in order)");
			 System.out.println("3. Delete an appointment");
			 System.out.println("4. Exit");
			 System.out.println("");
			 System.out.print("----Please make your choice and input the number (for example: 1):");
// scan the user's choice			
			String inputStr = scanner.nextLine();

			int inputNumber = Integer.parseInt(inputStr.trim().equals("")  ? "0" : inputStr);
// go to different functions ,depend on the user's choice.
// by using switch...case 
			switch (inputNumber) {
			case 0:
				break;
			case 1:
				Cappointment cappointment = new Cappointment();
				System.out.println("------Creating new appointment...");
				System.out.println("------please enter description :");
				String description = scanner.nextLine();
				cappointment.setDescription(description);
				System.out.println("------please enter start time (hh:mm): ");
				String startTime = scanner.nextLine();
// if the starttime is not valid , the user need to input again
				while (true) {
					if (!CTime.setTime(startTime)) {
						System.out.println("------please enter start time (hh:mm): ");
						startTime = scanner.nextLine();
					} else {
						cappointment.setStartTime(startTime);
						break;
					}

				}
// if the endtime is not valid , the user need to input again
				System.out.println("------please enter end time (hh:mm):");
				String endTime = scanner.nextLine();
				while (true) {
					if (!CTime.setTime(endTime)) {
						break;
					} else {
						cappointment.setEndTime(endTime);
						break;
					}
				}
// to make sure the end time is greater than the starttime
				boolean isEndTimeGreatThenStartTime = cappointment.isValidAppointment(cappointment.getStartTime(),
						cappointment.getEndTime());
				if (isEndTimeGreatThenStartTime) {
					cschedule.setCappointment(cappointment);
					System.out.println("------new appointment created.");
				}

				break;
//to show the appointments the user has
			case 2:
				System.out.println("------Your appointments are:");
				Collections.sort(cschedule.getCappointmentList(), new StartTimeComparator());
				for (int i = 0; i < cschedule.getCappointmentList().size(); i++) {
					System.out.println((i + 1) + "." + cschedule.getCappointmentList().get(i).getDescription() + "  from  "
							+ cschedule.getCappointmentList().get(i).getStartTime() + "  to  "
							+ cschedule.getCappointmentList().get(i).getEndTime());
				}
				break;
			case 3:
// choose one appointment to delete
				for (int i = 0; i < cschedule.getCappointmentList().size(); i++) {
					System.out.println((i + 1) + "." + cschedule.getCappointmentList().get(i).getDescription() + "  from  "
							+ cschedule.getCappointmentList().get(i).getStartTime() + "  to  "
							+ cschedule.getCappointmentList().get(i).getEndTime());
				}
				boolean shanchu = true;
				while (shanchu) {
// if no appointment, just exit the loop
					if(cschedule.getCappointmentList().size() == 0 ){
						System.out.println("------you have no appointments to delete");
						break;
					}
					else{
						System.out.println("------Please enter the appointment number to delete:");
						int num = scanner.nextInt();
// if the user input one number, but there is not a valid appointment.
						if (num > cschedule.getCappointmentList().size()) {
							System.out.println("------you have no  such appointments ");						
					}
						else {
							cschedule.getCappointmentList().remove(num - 1);
							System.out.println("------appointment " + num + "  has deleted ");
							shanchu = false;
						    break;
							}
						}

				}
				break;
			case 4:
//to exit the app.
				System.out.println("------Good bye and have a nice day!");
				select = false;
				break;
			}

		}
	}
}
