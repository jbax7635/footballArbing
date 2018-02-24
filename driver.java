import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract  class driver extends twoTeamDriver{
	//--win draw loose total
	public  Double teamOne1X2;
	public  WebElement teamOne1X2element ;
	public  Double teamTwo1X2;
	public  WebElement teamTwo1X2element ;
	public  Double draw1X2;
	public  WebElement draw1X2element ;
	//--win draw loose end of first half
	public  Double teamOne1X2FirstHalf;
	public  WebElement teamOne1X2FirstHalfelement ;
	public  Double teamTwo1X2FirstHalf;
	public  WebElement teamTwo1X2FirstHalfelement ;
	public  Double draw1X2FirstHalf;
	public  WebElement draw1X2FirstHalfelement ;
	
	public  ArrayList<ArrayList<ArrayList<ArrayList<Double>>>> eventDoubleArray = new ArrayList<ArrayList<ArrayList<ArrayList<Double>>>>();
	public  ArrayList<ArrayList<ArrayList<ArrayList<WebElement>>>> eventElementArray = new ArrayList<ArrayList<ArrayList<ArrayList<WebElement>>>>();
	
	
	WebDriver driver;
	boolean loggedIn = false;
	boolean started = false;
	
	
	public abstract void login();
	
	
	

		
	
	public void startDriver(String site){
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("webdriver.load.strategy", "unstable");
		profile.setPreference("dom.max_chrome_script_run_time", 0);
		profile.setPreference("dom.max_script_run_time", 0);
		profile.setPreference("browser.startup.homepage_override.mstone", "ignore");
		profile.setPreference("startup.homepage_welcome_url.additional",  "about:blank");
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.get(site);
		started=true;
		
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//ul[@class='list link-list horz swiper-wrapper']")));
		} catch (Exception k) {}
		
		
		
		
	}
	public void startDriver(Date date, String league, String sport, String region, String teamOne, String teamTwo){
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("webdriver.load.strategy", "unstable");
		profile.setPreference("dom.max_chrome_script_run_time", 0);
		profile.setPreference("dom.max_script_run_time", 0);
		profile.setPreference("browser.startup.homepage_override.mstone", "ignore");
		profile.setPreference("startup.homepage_welcome_url.additional",  "about:blank");
		driver = new FirefoxDriver(profile);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		 buildFromScratch(driver, date,  league,  sport, region,teamOne, teamTwo);
	if(started==false){
		driver.close();
	}
		
			
		
		}






	public abstract void getelementClicker(ArrayList<ArrayList<Integer>> arrayList);
	}
	






	
	

	

	


	


	


	


	

