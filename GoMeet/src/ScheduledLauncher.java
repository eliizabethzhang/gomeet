package src;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.Calendar; 

public class ScheduledLauncher {
	
	boolean aBDays;
	String icalURL;
	final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	final ScheduledFuture<?> [] tasks;
	int authUser;
	
	// times in HH:MM 24-hr. only A days used if no block scheduling
	private String [] aDayTimes;
	private String [] aDayCodes;
	private String [] bDayTimes;
	private String [] bDayCodes;
	
	// constructor
	public ScheduledLauncher(String [] aDayTimes, String [] aDayCodes, String [] bDayTimes, String [] bDayCodes, String icalURL, int authUser) {
		this.aBDays = true;
		this.icalURL = icalURL;
		this.authUser = authUser;
		this.aDayTimes = aDayTimes;
		this.aDayCodes = aDayCodes;
		this.bDayTimes = bDayTimes;
		this.bDayCodes = bDayCodes;
		
		// start the tasks by going through the arrays and putting them in the scheduler
		ScheduledFuture<?> [] tasks = new ScheduledFuture<?> [aDayTimes.length];
		for (int i = 0; i < aDayTimes.length; i++) {
			String time = aDayTimes[i];
			long timeInMinutes = TimeUnit.HOURS.toMinutes(Integer.parseInt(time.substring(0,2))) + Integer.parseInt(time.substring(3));
			long currentTimeInMinutes = TimeUnit.HOURS.toMinutes(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)) + Calendar.getInstance().get(Calendar.MINUTE); 
			long initialDelay = timeInMinutes - currentTimeInMinutes;
			
			String aCode = aDayCodes[i];
			String bCode = bDayCodes[i];
			tasks[i] = scheduler.scheduleAtFixedRate(() -> Utilities.launchMeet(aCode, bCode, icalURL, authUser), initialDelay, 1440, TimeUnit.MINUTES);
		}
		this.tasks = tasks;
	}
	
//  // not gonna bother
//	// constructor with no block scheduling
//	public ScheduledLauncher(String [] times, String [] codes) {
//		aBDays = false;
//		this.aDayTimes = times;
//		this.aDayCodes = codes;
//		
//	}
	
	// stops all scheduling (to be replaced with a new ScheduledLauncher object)
	public void delete() {
		for (ScheduledFuture<?> x: this.tasks) {
			x.cancel(true);
		}
		scheduler.shutdown();
	}
	
	
	// i put so much effort into this testing code i dont wanna delete it
//	public static void main(String [] args) {
//		String [] at = {"11:01", "13:30", "23:13", "23:12"};
//		String [] ac = {"hello", "Hello", "hello", "hello"};
//		String [] bt = {}; // this one lowkey doesn't matter
//		String [] bc = {"hi", "hi", "hi", "hi"};
//		ScheduledLauncher timer = new ScheduledLauncher(at, ac, bt, bc, "https://www.wcpss.net//site/handlers/icalfeed.ashx?MIID=1359", 0);
//		try {
//			TimeUnit.MINUTES.sleep(3);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		timer.delete();
//	}
	
}
