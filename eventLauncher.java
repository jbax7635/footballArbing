import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class eventLauncher extends Thread {
event event;
	public eventLauncher(event event1) {
		// TODO Auto-generated constructor stub
		event = event1;
	}
	
	public void  run(){
		System.out.println("event launched");
		
		loop:for(int y = 0;y<100;y++){
			
			Calendar currentDate = Calendar.getInstance();
					
			//--gets difference in time from now till event
			double	minutesTillEvent = getDateDiff(currentDate.getTime(),event.date,TimeUnit.MINUTES);
			System.out.println(minutesTillEvent);
			
			//--if event has more than five minutes to go then continue to check markets
			if (minutesTillEvent>=5&&event.eventStop==false){
				//--throttle loop for checking markets
				try {Thread.sleep(15000);} catch (Exception e) {}
				
				
				System.out.println("going to check markets");
					
event.checkMarket();}
				
				else{
					for(int q=0;q<event.driverArray.size();q++){
						try{event.driverArray.get(q).driver.close();}catch(Exception p){}
					}
					
					return;}
y--;}
		
			
			
	}
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
	}

}
