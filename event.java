import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.FileWriter;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public abstract class event {

	
    public  Date date;
    public String typeOfEvent;
	public abstract void startDrivers();
	
	public String league;
	public String sport;
	public String region;
	public String williamRefferenceSite=null;
	public  boolean webDriverPresence=false;
	public  boolean eventStop=false;
	public boolean eventStarted = false;
	
	public int[] marketBets = new int[]{ 0,0,0,0,0,0,0,0,0,0};
	public ArrayList<driver> driverArray = new ArrayList<driver>();

	public void checkMarket() {
		// TODO Auto-generated method stub

		
		
		
		for(int t=0;t<driverArray.size();t++)
		{
			
			//--will update data in driver objects
				//--if driver has been closed the size of the drivers will be checked and if there are less than 2 drivers, last one will be closed and loop broken
			try{driverArray.get(t).checkMarkets();}catch(Exception h){h.printStackTrace();}
				
		}
		
		
		
		
		
		/*/--test
		for(int h=1;h<driverArray.size();h++)
		{
			for (int y=0;y<driverArray.get(h).eventElementArray.size();y++)
			{
				for(int u=0; u<driverArray.get(h).eventElementArray.get(y).size();u++){
					for(int k=0;k<driverArray.get(h).eventElementArray.get(y).get(u).size();k++){
						for(int e=0;e<driverArray.get(h).eventElementArray.get(y).get(u).get(k).size();e++){
							
							try{
							Thread.sleep(500);
						}catch(InterruptedException b){}
							driverArray.get(h).getelementClicker(driverArray.get(h).eventElementArray.get(y).get(u).get(k).get(e));
							
							
						}
					}
				}
			}
		}
		
	System.exit(0);*/
		
		
		//--need to make refference array
		//-- bet 1 best price---bet 2 best price
		//-- driver whose bet it is---driver whose bet it is
		//-- element of bet---element of bet
		//--percentage of bet pool--percentage of bet pool
		
		ArrayList<ArrayList<ArrayList<Integer>>> bets = null;
	
		
		double bbets=0;
		for(int x=0; x < driverArray.get(0).eventDoubleArray.size(); x++){//--traverse markets
			foop:{System.out.println(driverArray.get(0).eventDoubleArray.size());
			if(marketBets[x]==0){
			int counter=0;
			bets = new ArrayList<ArrayList<ArrayList<Integer>>>();
			 bbets=0;
			
			for(int y=0; y < driverArray.get(0).eventDoubleArray.get(x).size(); y++){//--traverse element
				
				ArrayList<ArrayList<Integer>>nodebets = new ArrayList<ArrayList<Integer>>();
				
				double tempp =0;
				double current =1;
				
				for(int z=0; z < driverArray.get(0).eventDoubleArray.get(x).get(y).size(); z++){//--traverse nodes
					loop:{
					
					
					ArrayList<ArrayList<Integer>>tempnodebets = new ArrayList<ArrayList<Integer>>();
					
					int b;
					for( b=0; b < driverArray.get(0).eventDoubleArray.get(x).get(y).get(z).size(); b++){ //--traverse nodule
						
						ArrayList<Integer>tempnodulebets = new ArrayList<Integer>();
						
						double nodule=0;
						for(int a=0; a<driverArray.size(); a++){
							
							
							double temp=driverArray.get(a).eventDoubleArray.get(x).get(y).get(z).get(b);
							
							if(temp>nodule&&temp!=0){
								tempnodulebets.clear();
								nodule = temp;
								tempnodulebets.add(a);
								tempnodulebets.add(x);
								tempnodulebets.add(y);
								tempnodulebets.add(z);
								tempnodulebets.add(b);
								}
							
							}
						if(nodule !=0)
						{
						tempnodebets.add(tempnodulebets);}
						else{
							break loop;
						}
						
						
						
					}
					
					 tempp = nodeTotal(tempnodebets);
					 current = nodeTotal(nodebets);
					 
					 System.out.println(tempp);
					 System.out.println(current);
					 
					 
					if(tempp<current&&tempp!=0){
						System.out.println("changed");
						current = tempp;
						nodebets=tempnodebets;
						
					}
					
				}}
				counter++;
				System.out.println(current+"---current" + " "+counter);
				if(current!=0&&current!=1){
				bbets=bbets+current;
				bets.add(nodebets);}
				else{
					break foop;
				}
				
				
			
			}
			
		
		
		
		
		System.out.println(bbets+"     ----------bbets");
		if(bbets<.99){
			marketBets[x]=1;
			try {
			
				captureBet(bets);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		//--to be done at later stage when up and running	
		//	login(elementArray);
		//	placeBets(elementArray);
			eventStop=true;
			
		}}
		}}
		}
		
		
		private double nodeTotal(ArrayList<ArrayList<Integer>> tempnodebets) {
			double sum=0;
			
			try{
			for(int a=0;a<tempnodebets.size();a++){
			sum=sum+1/driverArray.get(tempnodebets.get(a).get(0)).eventDoubleArray.get(tempnodebets.get(a).get(1)).get(tempnodebets.get(a).get(2)).get(tempnodebets.get(a).get(3)).get(tempnodebets.get(a).get(4));
			}}catch(Exception i){}
			if(sum==0){
				return 1;
			}
		
		return sum;
	}


		
		
		
		//--check market(2)
		
		
	


	private void captureBet(ArrayList<ArrayList<ArrayList<Integer>>> bets) throws IOException {
		// TODO Auto-generated method stub
		//-- bet 1 best price---bet 2 best price
		//-- driver whose bet it is---driver whose bet it is
		//-- element of bet---element of bet
		//--percentage of bet pool--percentage of bet pool
		PrintWriter out = new PrintWriter(
				new FileWriter("c:\\users\\john\\desktop\\sports\\" + GetTimeStampValue() +""+sport+""+league+""+ "Bet.txt", true));
		
		for(int u=0;u<bets.size();u++){
			
			for(int f=0;f<bets.get(u).size();f++){
				driverArray.get(bets.get(u).get(f).get(0)).getelementClicker(bets.get(u));

captureScreenShot(driverArray.get(bets.get(u).get(f).get(0).intValue()).driver );
		
		}
			
		}
		out.close();
	}
	
	public  void captureScreenShot(WebDriver driver) throws IOException {
	    File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(screenshotFile,new File("c:\\users\\john\\desktop\\sports\\" + GetTimeStampValue() +""+sport+""+league+""+ "Bet.png"));
	}
	
	public  String GetTimeStampValue()throws IOException{
	    Calendar cal = Calendar.getInstance();       
	    Date time=cal.getTime();
	    String timestamp=time.toString();
	  
	    String systime=timestamp.replace(":", "-");
	  
	    return systime;
	}


	private void placeBets(ArrayList<ArrayList<Double>> elementArray) {
		// TODO Auto-generated method stub
		
	}


	private double evaluateBet(ArrayList<ArrayList<Double>> elementArray) {
		// TODO Auto-generated method stub
		
		double sum=0;
		for(int e=0;e<elementArray.size();e++){
			sum = sum+elementArray.get(e).get(0);
		}
		return sum;
	}
	
	public void login(ArrayList<ArrayList<Double>> elementArray) {
		
		ArrayList<Thread>collection=new ArrayList<Thread>();
		for(int y=0;y<=elementArray.size();y++)
		{
			
			
			int q = (elementArray.get(y).get(1)).intValue();
			
			if(driverArray.get(q).loggedIn==false){
			loginAssistant check = new loginAssistant(driverArray.get(q));
			check.start();
			collection.add(check);
			driverArray.get(q).loggedIn = true;
			}
		}
		
		
	}
		
		
	
	

}
