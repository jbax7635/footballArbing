import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class createEvents{
	static WebDriver createEventsDriver;
	static FirefoxProfile profile = new FirefoxProfile();
	
	static boolean firstStart=true;
	
	
	
	public static  void run(){
		
			epl();
			firstStart=false;
	
		
	}

	public static  void epl() {
		//--epl refferences				 
		 String refferenceSite="https://www.williamhill.com.au/soccer#offcanvas";
		String refferenceSiteTwo ="https://www.sbobet.com/euro/football/england";
		
		
		
		
		//--array to be built and passed back
		 ArrayList<event> eplArray = new ArrayList<event>();
		 //--webdriver profile
		profile.setPreference("webdriver.load.strategy", "unstable");
			profile.setPreference("dom.max_chrome_script_run_time", 0);
			profile.setPreference("dom.max_script_run_time", 0);
			profile.setPreference("browser.startup.homepage_override.mstone", "ignore");
			profile.setPreference("startup.homepage_welcome_url.additional",  "about:blank");
			//--new driver
			createEventsDriver = new FirefoxDriver(profile);
			WebDriverWait wait = new WebDriverWait(createEventsDriver, 10);
			WebDriverWait waitLonger = new WebDriverWait(createEventsDriver, 15);
			
			
			//--get site as refference
			createEventsDriver.get(refferenceSite);
			
			//wait for refference site to load
			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//ul[@class='list link-list horz swiper-wrapper']")));
			} catch (Exception k) {}
			
			String region=null;
			///--itterates through all soccer regions
			for (int h=5;h<=5;h++){
				loop1:try{
				//--selects region
				createEventsDriver.findElement(By
						.xpath("(//ul[@class='list link-list horz swiper-wrapper']//a)["+h+"]")).click();
				//--gets region for object
				region =createEventsDriver.findElement(By
						.xpath("(//ul[@class='list link-list horz swiper-wrapper']//a)["+h+"]")).getText();
				
				//--waits for region to be active
			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//ul[@class='list link-list horz swiper-wrapper']//a)["+h+"][@class='is-active']")));
			} catch (Exception k) {System.out.println("f");break loop1;}
			
			
			//--select all leagues in region
			for(int y=1;y<=12;y++){
				goop:{
				try{
				WebElement elemtnt = createEventsDriver.findElement(By.xpath("(//ul[@class='items']//a//b)["+y+"]//ancestor::li[@class='checked']"));
				break goop;
				}catch(Exception r){try{WebElement element=	createEventsDriver.findElement(By
							.xpath("(//ul[@class='items']//a//b)["+y+"]"));
				element.click();
					}catch(Exception p){break;}}
					
		
			try{
				wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("(//ul[@class='items']//a//b)["+y+"]//ancestor::li[@class='current-checked checked']")));
			}catch(Exception z){createEventsDriver.navigate().refresh();y=2;
			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//ul[@class='list link-list horz swiper-wrapper']")));
			} catch (Exception k) {}}}}
			
			
			//--loops all matches displayed
			for(int q=1;q<=100;q++){
			try{
				
				//--takes the time till event and creates date object
			String datee=	createEventsDriver.findElement(By
						.xpath("(//div[@class='large-8 columns event-title'])["+q+"]//time")).getText();
			
			 DateFormat dateFormat = new SimpleDateFormat("yyyy");
			Calendar currentDate = Calendar.getInstance();
			String year=dateFormat.format(currentDate.getTime());
			
			
			String[] dates = datee.split("AEST")	;		
			DateFormat format = new SimpleDateFormat("dd MMM, HH:mm yyyy");
			Date date = format.parse(dates[0].trim()+ " "+ year);
			
			
			String league =createEventsDriver.findElement(By
					.xpath("(//div[@class='large-8 columns event-title'])["+q+"]//time//ancestor::div[@id='sports-market-wrapper']//a[@class='left']")).getText().replace("Matches","").trim();
			
			//--creates the refference site for william hill driver
			
			refferenceSite=createEventsDriver.findElement(By
					.xpath("(//div[@class='large-8 columns event-title'])["+q+"]//a[1]")).getAttribute("href");
			
			
			
			//-- gets the names of each team
			String[] teams;
			String siteGrab=createEventsDriver.findElement(By
					.xpath("(//div[@class='large-8 columns event-title'])["+q+"]//a[1]")).getText();
			teams=siteGrab.split("vs");
			String teamOne= teams[0].trim();
			String teamTwo=teams[1].trim();
			
			System.out.println(teamOne);
			System.out.println(teamTwo);
			
			//--ensures the event is not already running and another identical event gets added
			double	minutesTillEvent = startBot.getDateDiff(currentDate.getTime(),date,TimeUnit.MINUTES);
			if((firstStart==false&&minutesTillEvent>startBot.MinutesBeforeEventToWatchMarket+5)||firstStart==true)
			{
			epl thisEvent = new epl(date,teamOne.replaceAll("FC","").replaceAll("United","").replaceAll("City","").replaceAll("CA","").replaceAll("CD","").replaceAll("AFC","").trim(),teamTwo.replaceAll("City","").replaceAll("FC","").replaceAll("United","").replaceAll("CA","").replaceAll("AFC","").replaceAll("CD","").trim(),refferenceSite);
			thisEvent.sport = "soccer";
			thisEvent.league = league;
			thisEvent.region = region;
			eplArray.add(thisEvent);
			}
					
					
					
				
			}catch(Exception u){}}
		
				}catch(Exception q){} }
			
			startBot.todaysEvents.addAll(eplArray);
			createEventsDriver.close();
	}

	

}
