import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class williamDriver extends driver {
Boolean clickerPrescence = false;
ArrayList<ArrayList<ArrayList<ArrayList<String>>>> eventElementArray = new ArrayList<ArrayList<ArrayList<ArrayList<String>>>>();
String teamOne1X2element=null;
	@Override
	public void login() {
		// TODO Auto-generated method stub

	}

	@Override
	public void buildFromScratch(WebDriver driver2, Date date, String league, String sport, String region,
			String teamOne, String teamTwo) {

		// TODO Auto-generated method stub

	}

	@Override
	public void checkMarkets() {
		WebDriverWait waitLonger = new WebDriverWait(driver, 5);
driver.navigate().refresh();
String popularMarkets = "//a[@data-gaq-id='Popular Markets'][@class='is-active']/ancestor::div[@class='large-8 columns']";
String firstHalf = "//a[@data-gaq-id='1st Half'][@class='is-active']/ancestor::div[@class='large-8 columns ']";		
		try {
			waitLonger.until(ExpectedConditions
					.invisibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets']")));}catch(Exception n){}
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets']")));}catch(Exception n){}
	 eventDoubleArray.clear();
		eventElementArray.clear();
		boolean HTFT=true;

		// -- clicks on first half refference

		String[] teams;
		String[] teamss;
		String teamHeader = driver.findElement(By.xpath("//h3[@class='clearfix']")).getText();
		teams = teamHeader.split("\n");
	
		teamss = teams[0].split("vs");
		String teamOne = teamss[0].trim();
		String teamTwo = teamss[1].trim();
		System.out.println(teamOne+teamTwo);
		

		ArrayList<ArrayList<Double>> element = null;

		ArrayList<Double> node = null;

		ArrayList<ArrayList<String>> elementElement = null;

		ArrayList<String> nodeElement = null;
		
		 
		  
		
		

		try {
			driver.findElement(By.xpath("//a[@data-gaq-id='Popular Markets']")).click();
		} catch (Exception i) {
		}

		
		
		// --Market 1-Win Draw Lose (3 Elements)
		 ArrayList<ArrayList<ArrayList<Double>>> marketDoubleArray = new ArrayList<ArrayList<ArrayList<Double>>>();
		  ArrayList<ArrayList<ArrayList<String>>> marketElementArray = new ArrayList<ArrayList<ArrayList<String>>>();

		// --element 1 home team win

		element = new ArrayList<ArrayList<Double>>();
		elementElement = new ArrayList<ArrayList<String>>();

		// --node 1 element 1

		node = new ArrayList<Double>();
		nodeElement = new ArrayList<String>();

		// --nodule 1
		System.out.println("william");
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element =popularMarkets+
					"//span[@data-competitor-name='" + teamOne + "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By
					.xpath("(//span[@data-competitor-name='" + teamOne + "'])//parent::div//following-sibling::div//a"))
					.getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			System.out.println("Problems collecting");
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);

		elementElement.add(nodeElement);
		element.add(node);

		// --node 2 element 1 home team win HT/FT

		node = new ArrayList<Double>();
		nodeElement = new ArrayList<String>();

		// --nodule 1 home team win/win
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element = popularMarkets+"//span[@data-competitor-name='" + teamOne + "/" + teamOne + "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("(//span[@data-competitor-name='" + teamOne
					+ "/" + teamOne + "'])//parent::div//following-sibling::div//a")).getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
			HTFT=false;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);
if(HTFT==true){
		// --nodule 2 draw/win
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element =popularMarkets+"//span[@data-competitor-name='" + "Draw" + "/" + teamOne
					+ "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("(//span[@data-competitor-name='" + "Draw" + "/"
					+ teamOne + "'])//parent::div//following-sibling::div//a")).getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);

		// --nodule 3 lose/win
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element = popularMarkets+"//span[@data-competitor-name='" + teamTwo + "/" + teamOne
					+ "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("(//span[@data-competitor-name='" + teamTwo
					+ "/" + teamOne + "'])//parent::div//following-sibling::div//a")).getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);}
else{
	teamOne1X2element = null;
	teamOne1X2 = 0.0;
	node.add(teamOne1X2);
	nodeElement.add(teamOne1X2element);
	node.add(teamOne1X2);
	nodeElement.add(teamOne1X2element);
	
	
}

		elementElement.add(nodeElement);
		element.add(node);

		marketDoubleArray.add(element);
		marketElementArray.add(elementElement);

		// --element 2 Draw

		element = new ArrayList<ArrayList<Double>>();
		elementElement = new ArrayList<ArrayList<String>>();

		// --node 1 element 2 Draw
		node = new ArrayList<Double>();
		nodeElement = new ArrayList<String>();

		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element = popularMarkets+"//span[@data-competitor-name='Draw']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver
					.findElement(
							By.xpath("(//span[@data-competitor-name='Draw'])//parent::div//following-sibling::div//a"))
					.getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);
		
		elementElement.add(nodeElement);
		element.add(node);

		// --node 2 element 2 Draw

		node = new ArrayList<Double>();
		nodeElement = new ArrayList<String>();
if(HTFT==true){
		// --nodule 1 home team win/Draw
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element = popularMarkets+"//span[@data-competitor-name='" + teamOne + "/" + "Draw"
					+ "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("(//span[@data-competitor-name='" + teamOne + "/" + "Draw"
					+ "'])//parent::div//following-sibling::div//a")).getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);

		// --nodule 2 draw/Draw
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element = popularMarkets+"//span[@data-competitor-name='" + "Draw" + "/" + "Draw"
					+ "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("(//span[@data-competitor-name='" + "Draw" + "/" + "Draw"
					+ "'])//parent::div//following-sibling::div//a")).getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);

		// --nodule 3 lose/Draw

		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element = popularMarkets+"//span[@data-competitor-name='" + teamTwo + "/" + "Draw"
					+ "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("(//span[@data-competitor-name='" + teamTwo + "/" + "Draw"
					+ "'])//parent::div//following-sibling::div//a")).getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);}
else{
	teamOne1X2element = null;
	teamOne1X2 = 0.0;
	node.add(teamOne1X2);
	nodeElement.add(teamOne1X2element);
	node.add(teamOne1X2);
	nodeElement.add(teamOne1X2element);
	node.add(teamOne1X2);
	nodeElement.add(teamOne1X2element);
	
}

		elementElement.add(nodeElement);
		element.add(node);

		marketDoubleArray.add(element);
		marketElementArray.add(elementElement);

		// --element 3

		element = new ArrayList<ArrayList<Double>>();
		elementElement = new ArrayList<ArrayList<String>>();

		// --node 1 element 3 Away Team Win
		node = new ArrayList<Double>();
		nodeElement = new ArrayList<String>();
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element = popularMarkets+"//span[@data-competitor-name='" + teamTwo + "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By
					.xpath("(//span[@data-competitor-name='" + teamTwo + "'])//parent::div//following-sibling::div//a"))
					.getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);

		elementElement.add(nodeElement);
		element.add(node);

		// --node 2 element 3 Away Team Win

		node = new ArrayList<Double>();
		nodeElement = new ArrayList<String>();
if(HTFT==true){
		// --nodule 1 home team win/lose
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element = popularMarkets+"//span[@data-competitor-name='" + teamOne + "/" + teamTwo
					+ "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("(//span[@data-competitor-name='" + teamOne
					+ "/" + teamOne + "'])//parent::div//following-sibling::div//a")).getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);

		// --nodule 2 draw/lose
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element =popularMarkets+"//span[@data-competitor-name='" + "Draw" + "/" + teamTwo
					+ "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("(//span[@data-competitor-name='" + "Draw" + "/"
					+ teamOne + "'])//parent::div//following-sibling::div//a")).getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);

		// --nodule 3 lose/lose
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));

			teamOne1X2element = popularMarkets+"//span[@data-competitor-name='" + teamTwo + "/" + teamTwo
					+ "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("(//span[@data-competitor-name='" + teamTwo
					+ "/" + teamOne + "'])//parent::div//following-sibling::div//a")).getText());
			System.out.println(teamOne1X2);

		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);}
else{
	teamOne1X2element = null;
	teamOne1X2 = 0.0;
	node.add(teamOne1X2);
	nodeElement.add(teamOne1X2element);
	node.add(teamOne1X2);
	nodeElement.add(teamOne1X2element);
	node.add(teamOne1X2);
	nodeElement.add(teamOne1X2element);
	
}

		elementElement.add(nodeElement);
		element.add(node);

		marketDoubleArray.add(element);
		marketElementArray.add(elementElement);

		eventDoubleArray.add(marketDoubleArray);
		eventElementArray.add(marketElementArray);
		
		
		  
		// --Market 2---Win draw lose- first half (3 Elements)
		marketDoubleArray = new ArrayList<ArrayList<ArrayList<Double>>>();
		  marketElementArray = new ArrayList<ArrayList<ArrayList<String>>>();

		try {
			driver.findElement(By.xpath("//a[@data-gaq-id='1st Half']")).click();
		} catch (Exception j) {
		}

		// --element 1 home team win

		element = new ArrayList<ArrayList<Double>>();
		elementElement = new ArrayList<ArrayList<String>>();

		// --node 1 element 1

		node = new ArrayList<Double>();
		nodeElement = new ArrayList<String>();

		// --nodule 1
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='1st Half'][@class='is-active']")));

			teamOne1X2element = firstHalf+"//span[@data-competitor-name='" + teamOne + "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By
					.xpath("(//span[@data-competitor-name='" + teamOne + "'])//parent::div//following-sibling::div//a"))
					.getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			System.out.println("Problems collecting");
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);

		elementElement.add(nodeElement);
		element.add(node);
		
		marketDoubleArray.add(element);
		marketElementArray.add(elementElement);

		// --element 2 Draw

		element = new ArrayList<ArrayList<Double>>();
		elementElement = new ArrayList<ArrayList<String>>();

		// --node 1 element 2 Draw
		node = new ArrayList<Double>();
		nodeElement = new ArrayList<String>();

		// --nodule 1
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='1st Half'][@class='is-active']")));

			teamOne1X2element = firstHalf+"//span[@data-competitor-name='Draw']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver
					.findElement(
							By.xpath("(//span[@data-competitor-name='Draw'])//parent::div//following-sibling::div//a"))
					.getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);

		elementElement.add(nodeElement);
		element.add(node);
		
		marketDoubleArray.add(element);
		marketElementArray.add(elementElement);

		// --element 3

		element = new ArrayList<ArrayList<Double>>();
		elementElement = new ArrayList<ArrayList<String>>();

		// --node 1 element 3 Away Team Win
		
		node = new ArrayList<Double>();
		nodeElement = new ArrayList<String>();
		try {
			waitLonger.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='1st Half'][@class='is-active']")));

			teamOne1X2element = firstHalf+"//span[@data-competitor-name='" + teamTwo + "']//parent::div//following-sibling::div//small";
			teamOne1X2 = Double.parseDouble(driver.findElement(By
					.xpath("(//span[@data-competitor-name='" + teamTwo + "'])//parent::div//following-sibling::div//a"))
					.getText());
			System.out.println(teamOne1X2);
		} catch (Exception k) {
			k.getStackTrace();
			
			teamOne1X2element = null;
			teamOne1X2 = 0.0;
		}

		node.add(teamOne1X2);
		nodeElement.add(teamOne1X2element);

		elementElement.add(nodeElement);
		element.add(node);
		
		marketDoubleArray.add(element);
		marketElementArray.add(elementElement);
		
		eventDoubleArray.add(marketDoubleArray);
		eventElementArray.add(marketElementArray);

	}
	public void getelementClicker(ArrayList<ArrayList<Integer>> bets) {
		// TODO Auto-generated method stub
WebDriverWait waitLonger = new WebDriverWait(driver, 3);
		
		if(clickerPrescence==true){
		driver.findElement(By.xpath(".//*[@id='app-responsive-sidebarContainer']/div/div[1]/a[2]")).click();}
		
		for (int u=0;u<bets.size();){

			try {
				driver.findElement(By.xpath("//a[@data-gaq-id='Popular Markets']")).click();
				} catch (Exception i) {
			}

			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='Popular Markets'][@class='is-active']")));
				
			driver.findElement(By.xpath(eventElementArray.get(bets.get(u).get(1)).get(bets.get(u).get(2)).get(bets.get(u).get(3)).get(bets.get(u).get(4)))).click();
			}catch(Exception j){

				try {
					driver.findElement(By.xpath("//a[@data-gaq-id='1st Half']")).click();} catch (Exception i) {}
				try {
					waitLonger.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//a[@data-gaq-id='1st Half'][@class='is-active']")));
				}catch(Exception g){
					driver.findElement(By.xpath(eventElementArray.get(bets.get(u).get(1)).get(bets.get(u).get(2)).get(bets.get(u).get(3)).get(bets.get(u).get(4)))).click();
					
				}
			}
			
			
		}
		
		
		driver.findElement(By.xpath(".//*[@id='app-responsive-sidebarContainer']/div/div[1]/a[2]")).click();
		clickerPrescence=true;
		
		
			
			
			
	
			
			
		
		
		
		
	}

}
