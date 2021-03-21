package src;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.awt.Desktop;
import java.net.URI;
import java.net.URISyntaxException;

public class Utilities {
	
	// get if it's an A or B day
	// returns 'A', 'B', or 'O' (off day, eg weekend)
	// note: Enloe's ical URL is https://www.wcpss.net//site/handlers/icalfeed.ashx?MIID=1359
	// i tested this and it works. unless theres a problem with how i closed the resource ical scanner
	public static char aOrBDay(String icalURL) throws MalformedURLException, IOException {
		
		// get ics file
		URL url = new URL(icalURL);
		Scanner ical = new Scanner(url.openStream());
		
		// get date in format YYYYMMDD
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
		String today = LocalDate.now().format(formatter);
		//System.out.println("current date in yyyymmdd is: " + today);
		
		// reach line that says A or B day, then see if this line corresponds to today.
		// If the date in this line in ical file is greater than today's date you've gone too far
		// YYYYMMDD
		// each iteration is one calendar event that tells an A or B day but not necessarily for today's date
		boolean found = false;
		char day = 'O';
		while (!found) {
			
			char potentialDay = 'O';
			String eventDate = "";
			boolean patternMatch = false;
			
			// find A or B day line
			while (!patternMatch) {
				
				String line = ical.nextLine();
				
				if (line.equals("SUMMARY:A Day")) {
					potentialDay = 'A';
					patternMatch = true;
				} else if (line.equals("SUMMARY: B DAY")) {
					potentialDay = 'B';
					patternMatch = true;
				}
				
			}
			
			// find event's date line
			patternMatch = false;
			while (!patternMatch) {
				
				String line = ical.nextLine();
				
				if (line.substring(0, 8).equals("DTSTART:")) {
					
					eventDate = line.substring(8);
					patternMatch = true;
					
				}
				
			}
			
			// figure out if this is the one we're looking for
			if (Integer.parseInt(eventDate) < Integer.parseInt(today)) { // before today
				found = false;
			} else if (Integer.parseInt(eventDate) == Integer.parseInt(today)) { // today
				day = potentialDay;
				found = true;
			} else { // after today
				potentialDay = 'O';
				day = potentialDay;
				found = true;
			}
			
		}
		
		// done
		ical.close();
		return day;
		
	}

	// this is self-explanatory.
	// i tested this and it works
	public static void launchMeet(String meetCode, int authUser) throws URISyntaxException, IOException {
		
		URI uri = new URI("https://meet.google.com/lookup/" + meetCode + "?authuser=" + authUser);
		
		Desktop d = Desktop.getDesktop();
		d.browse(uri);
		
	}
	
}
