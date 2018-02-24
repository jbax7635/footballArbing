import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class epl extends twoTeamEvent{
	

	
	
	public epl(Date dat, String teamOn, String teamTw, String williamsRefference) {
		// TODO Auto-generated constructor stub
		date=dat;
		teamOne =teamOn ;
		teamTwo = teamTw;
		williamRefferenceSite=williamsRefference;
	
		
	}
	

	@Override
	public void startDrivers() {
		// TODO Auto-generated method stub
		//--creates william driver
		williamDriver driver = new williamDriver();
		driverStarter william = new driverStarter(driver,williamRefferenceSite);
		william.start();
		
		
		//--creates sbo driver
		sboDriver driverer = new sboDriver();
		driverStarter sbo = new driverStarter(driverer,date,league,sport,region,teamOne,teamTwo);
		sbo.start();
		System.out.println("drivers starting");
		
		//--waits untill al drivers are created
		while(william.isAlive()==true||sbo.isAlive()==true){
			System.out.println("waiting");
			try{
				Thread.sleep(10000);
			}catch(InterruptedException b){}
			
			
		}
		webDriverPresence=true;
		
		//--if launched then added
		if(driverer.started==true){
			System.out.println("added");
		driverArray.add(driverer);}
		
		//--if launched then added
		if(driver.started==true){
			System.out.println("added2");
		driverArray.add(driver);}
		
		//--will close remaining driver windows if array size is smaller than a given size
		if(driverArray.size()<2){
			for(int y=0;y<driverArray.size();y++){
				driverArray.get(y).driver.close();
			}
		}
	}

	




	


	

	

}
