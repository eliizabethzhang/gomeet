package src;

public class ScheduledLauncher {
	
	// times in HH:MM 24-hr, each array should be 4 elements long
	private String [] aDayTimes;
	private String [] aDayCodes;
	private String [] bDayTimes;
	private String [] bDayCodes;
	
	// constructor
	public ScheduledLauncher(String [] aDayTimes, String [] aDayCodes, String [] bDayTimes, String [] bDayCodes) {
		this.aDayTimes = aDayTimes;
		this.aDayCodes = aDayCodes;
		this.bDayTimes = bDayTimes;
		this.bDayCodes = bDayCodes;
	}
	
	// stops all scheduling to be replaced with a new schedule
	public void delete() {
		aDayTimes = null;
		aDayCodes = null;
		bDayTimes = null;
		bDayCodes = null;
	}
	
}
