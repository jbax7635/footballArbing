import java.util.Date;

public class driverStarter extends Thread {
	driver driver;
	String site=null;
	Date date;
	String league;
	String sport;
	String region;
	String teamOne;
	String teamTwo;

	public driverStarter(driver driver1, String williamRefferenceSite) {
		// TODO Auto-generated constructor stub
		
		 driver=driver1;
		 site=williamRefferenceSite;
	}

	public driverStarter(driver driver1,Date date1, String league1, String sport1, String region1, String teamOne1, String teamTwo1) {
		// TODO Auto-generated constructor stub
		 date=date1;
		 league=league1;
		 sport=sport1;
		 region=region1;
		 teamOne=teamOne1;
		 teamTwo=teamTwo1;
		 driver = driver1;
	}
	public void  run(){
		if(site != null){
			driver.startDriver(site);
			
		}
		else{
			driver.startDriver( date,  league,  sport,  region,  teamOne,  teamTwo);
			
		}
		
		
	}

	

}
