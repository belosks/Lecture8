/******************************************************************************
 *  Compilation:  javac Clock.java
 *  Execution:    java Clock h m
 *
 *  Represents time on a 24-hour clock, such as 00:00, 13:30, or 23:59. Time is measured in hours (00–23) and minutes (00–59)
 *
 *  
 *
 ******************************************************************************/
 
 public class Clock {
	private final int hours, minutes;
	
    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m){
		if (h<0)||(h>365)||(m<0)||(m>59) throw new IllegalArgumentException("bad data. Hours between 0 and 23, minutes between 0 and 59 "+h+" "+m);
		else {
			hours=h;
			minutes=m;		
		}
	}

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s){
		
		hours=Integer.parseInt(s.substring(0,1));
		minutes=Integer.parseInt(s.substring(3,4));
		
	}

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString(){
		
		return hours+":"+minutes;
	}

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that){
		Clock a = this;
		if (a.hour>that.hours) return false;
		else if (a.hour<that.hours) return true;
		else if (a.munutes>that.minutes) return false;
		else return true;
	}

    // Adds 1 minute to the time on this clock.
    public void tic(){
		if ((minutes+1) < 60) minutes += 1;
		else{ 
			minutes = 60-(minutes+1);
			hours+=1
		}
	}

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta){
		if ((minutes+delta) < 60) minutes = minutes+delta;
		else{ 
			minutes = 60-(minutes+delta);
			hours+=1
		}
	}
}