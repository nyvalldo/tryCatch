package ApplicationExcecoesPersonalizadas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Model.entities.Reservation;

public class ProgramExcecoesPersonalizadas {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in); 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation res = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + res);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			
			else if(!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				res.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + res);	
			}					
		}		
		
		sc.close();
	}
}
