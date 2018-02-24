import java.util.Date;

import org.openqa.selenium.WebDriver;

public abstract  class twoTeamDriver extends Thread {
	
	
	
	
	public abstract  void buildFromScratch(WebDriver driver2, Date date, String league, String sport, String region, String teamOne, String teamTwo);
	//public abstract void readyDriver();
	public void checkMarkets(){}
}
