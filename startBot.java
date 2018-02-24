import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class startBot {

	static double hourToCollectEvents = 05;
	static double minuteToCollectEvents = 0;
	static double MinutesBeforeEventToWatchMarket=60;
	static ArrayList<event> todaysEvents = new ArrayList<event>();
	static boolean starterPrescence=false;
	

	public static void main(String[] args) {
		//-daily loop
		/*FirefoxProfile profile = new FirefoxProfile();
		
		profile.setPreference("webdriver.load.strategy", "unstable");
		profile.setPreference("dom.max_chrome_script_run_time", 0);
		profile.setPreference("dom.max_script_run_time", 0);
		profile.setPreference("browser.startup.homepage_override.mstone", "ignore");
		profile.setPreference("startup.homepage_welcome_url.additional",  "about:blank");
		//--new driver
		FirefoxDriver createEventsDriver = new FirefoxDriver(profile);
		
		createEventsDriver.get("https://www.williamhill.com.au/soccer/37725797/d/kasimpasa-vs-fenerbahce");
		try{
			Thread.sleep(5000);
		}catch(InterruptedException b){}
		
		createEventsDriver.findElement(By
				.xpath("(//span[@data-competitor-name='Fenerbahce'])//parent::div//following-sibling::div//small")).click();
		
		
		String text =createEventsDriver.findElement(By
				.xpath(".//*[@id='app-responsive-sidebarContainer']//a[2]")).getText();
		System.out.println(text);
		
		
		WebDriverWait wait = new WebDriverWait(createEventsDriver, 5);
		try{
			System.out.println("1");
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//a[@data-grouping-desc='Straight']//ancestor::section[@class='block flat']//a[@data-link-type='placeSportBet'])[1]")));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@class='btn-block'])[1]")));
		}catch(Exception h){}
		System.out.println("2");
		WebElement f =createEventsDriver.findElement(By
				.xpath("(//a[@data-grouping-desc='Straight']//ancestor::section[@class='block flat']//a[@data-link-type='placeSportBet'])[1]"));
		System.out.println("3");
		System.out.println(f.getText());
		System.out.println("4");
		*/
		for(int r=0;r<2; r++){
			
		
		//-gets instance of calendar and creates minute and hour in double format
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat compareFormat = new SimpleDateFormat("yy/MM/dd HH:mm:ss");
		SimpleDateFormat twentyFourHourFormat = new SimpleDateFormat("mm");
		SimpleDateFormat hourFormat = new SimpleDateFormat("HH");
		String minuteTime = twentyFourHourFormat.format(currentDate.getTime());
		double minute = Double.parseDouble(minuteTime);
		String hourTime = hourFormat.format(currentDate.getTime());
		double hour = Double.parseDouble(hourTime);
		
		//--at given time, events will be created for the day
		if(hourToCollectEvents==hour&&minuteToCollectEvents<=minute&&starterPrescence==false){
			todaysEvents.clear();
			starterPrescence=true;
			Thread driver = new eventCreator();
			driver.start();	
			
			while(driver.isAlive()==true){
				
				try{
					Thread.sleep(5000);
				}catch(InterruptedException b){}
				
				
			}
			
			
			
		}
		//--reset starter prescence, so only one opens at a time
		if(hourToCollectEvents==hour+1){
			starterPrescence=false;
				
		}
		
		
		
		//--continuous loop to continually to its contence
		for(int t=0;t<todaysEvents.size();t++){
			//--refresh time each loop
			currentDate = Calendar.getInstance();
			 minuteTime = twentyFourHourFormat.format(currentDate.getTime());
			 minute = Double.parseDouble(minuteTime);
			 hourTime = hourFormat.format(currentDate.getTime());
			 hour = Double.parseDouble(hourTime);
			
			 
			
			
			
		//--will open webdrivers a given amount of hours before the event and check the markets,will only check 
		//market if webdriver present and will open if not present
		for(int y=0;y<todaysEvents.size();y++){
			/*gets the difference of date now and date of event in minutes*/

double	minutesTillEvent = getDateDiff(currentDate.getTime(),todaysEvents.get(y).date,TimeUnit.MINUTES);

			if((minutesTillEvent<=MinutesBeforeEventToWatchMarket &&minutesTillEvent>5)||todaysEvents.get(y).webDriverPresence==true){
				
				
				if(todaysEvents.get(y).webDriverPresence==false && todaysEvents.get(y).eventStarted==false){
					System.out.println("starting");
					todaysEvents.get(y).startDrivers();}
				
				if(todaysEvents.get(y).webDriverPresence==true&&todaysEvents.get(y).eventStarted==false&&todaysEvents.get(y).driverArray.size()>1){
					System.out.println("launching");
					todaysEvents.get(y).eventStarted=true;
					eventLauncher thread = new eventLauncher(todaysEvents.get(y));
					thread.start();
					
					
					
					}
				
			}
		}
		}
	
		
		
			try {
				Thread.sleep(1800000);//600000);

			} catch (Exception e) {}
				
		
		
		
		r--;}
	
		
	}
	
	/**
	 * Get a diff between two dates
	 * @param date1 the oldest date
	 * @param date2 the newest date
	 * @param timeUnit the unit in which you want the diff
	 * @return the diff value, in the provided unit
	 */
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
		
	    long duration = date2.getTime() - date1.getTime();
	    long diffInMinutes = TimeUnit.MILLISECONDS.toMinutes(duration);
	    return diffInMinutes;
	}

}
