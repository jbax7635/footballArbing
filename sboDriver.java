import java.util.ArrayList;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class sboDriver extends driver {

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
		
		
				
	}

	@Override
	public void buildFromScratch(WebDriver driver, Date date, String league, String sport, String region,
			String teamOne, String teamTwo) {
		// TODO Auto-generated method stub
		boolean foundMatch = false;
		if(sport.equalsIgnoreCase("soccer")){
			driver.get("https://www.sbobet.com/euro/football");
			
			
			WebDriverWait waitLonger = new WebDriverWait(driver, 10);
			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("(//td[@class='Fav'])[1]/following-sibling::node()[1]")));
			} catch (Exception k) {}
			
			//--remove "city","united","FC","CA","CD" from names 
			for(int e=1;e<=400;e++){
				
				
				
				try{
				String nameOne=
				driver.findElement(By
						.xpath("(//td[@class='Fav'])["+e+"]/following-sibling::node()[1]//a")).getAttribute("title");
				String nameTwo=
						driver.findElement(By
								.xpath("(//td[@class='Fav'])["+e+"]/following-sibling::node()[3]//a")).getAttribute("title");
				
				nameOne = nameOne.replaceAll("FC","").replaceAll("United","").replaceAll("CA","").replaceAll("City","").replaceAll("CD","").replaceAll("AFC","").trim();
				nameTwo = nameTwo.replaceAll("FC","").replaceAll("United","").replaceAll("CA","").replaceAll("City","").replaceAll("CD","").replaceAll("AFC","").trim();
				System.out.println(nameOne+"team One");
				System.out.println(nameTwo+"team Two");
				
				if(nameOne.equalsIgnoreCase(teamOne)||nameTwo.equalsIgnoreCase(teamTwo)){
					String href = driver.findElement(By
							.xpath("(//td[@class='Fav'])["+e+"]/following-sibling::node()[4]//a")).getAttribute("href");
					String firstSectionURL = "https://www.sbobet.com";
					started = true;
					driver.get(href);
					break;
				} }catch(Exception j){
				}
				
			}
			
			
		}
		
		
		
		
	}

	@Override
	public void checkMarkets() {
		// TODO Auto-generated method stub
		WebDriverWait waitLonger = new WebDriverWait(driver, 5);
driver.navigate().refresh();
try{
	Thread.sleep(2000);
}catch(InterruptedException b){}
System.out.println("SBO");
		
	
		
		 eventDoubleArray.clear();
			eventElementArray.clear();
		boolean HTFT = true;
		
		String[] teams;
		String teamHeader=	driver.findElement(By
					.xpath("//div[@class='HdTitle']//span")).getText();
			teams = teamHeader.split("-vs-");
			String teamOne = teams[0].trim();
			String teamTwo = teams[1].trim();
			
			System.out.println(teamOne);
			System.out.println(teamTwo);
			ArrayList<ArrayList<Double>> element = null;

			ArrayList<Double> node = null;

			ArrayList<ArrayList<WebElement>> elementElement = null;

			ArrayList<WebElement> nodeElement = null;
			
			 
			WebDriverWait wait = new WebDriverWait(driver, 12);
			
			

		

			
			
			// --Market 1-Win Draw Lose (3 Elements)
			 ArrayList<ArrayList<ArrayList<Double>>> marketDoubleArray = new ArrayList<ArrayList<ArrayList<Double>>>();
			  ArrayList<ArrayList<ArrayList<WebElement>>> marketElementArray = new ArrayList<ArrayList<ArrayList<WebElement>>>();

			// --element 1 home team win

			element = new ArrayList<ArrayList<Double>>();
			elementElement = new ArrayList<ArrayList<WebElement>>();

			// --node 1 element 1

			node = new ArrayList<Double>();
			nodeElement = new ArrayList<WebElement>();

			// --nodule 1
			try {
				
				wait.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath(
						"//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By
						.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span"))
						.getText());
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
			nodeElement = new ArrayList<WebElement>();

			// --nodule 1 home team win/win
			try {
				
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));
//--testing
				teamOne1X2element = driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Home - Home']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Home - Home']//preceding-sibling::span")).getText());
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
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Draw - Home']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Draw - Home']//preceding-sibling::span")).getText());
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
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Away - Home']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Away - Home']//preceding-sibling::span")).getText());
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
			elementElement = new ArrayList<ArrayList<WebElement>>();

			// --node 1 element 2 Draw
			node = new ArrayList<Double>();
			nodeElement = new ArrayList<WebElement>();

			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(
						By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver
						.findElement(
								By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='']//preceding-sibling::span"))
						.getText());
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
			nodeElement = new ArrayList<WebElement>();
if(HTFT==true){
			// --nodule 1 home team win/Draw
			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Home - Draw']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Home - Draw']//preceding-sibling::span")).getText());
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
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Draw - Draw']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Draw - Draw']//preceding-sibling::span")).getText());
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
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Away - Draw']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Away - Draw']//preceding-sibling::span")).getText());
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
			elementElement = new ArrayList<ArrayList<WebElement>>();

			// --node 1 element 3 Away Team Win
			node = new ArrayList<Double>();
			nodeElement = new ArrayList<WebElement>();
			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath(
						"//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamTwo+"']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By
						.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamTwo+"']//preceding-sibling::span"))
						.getText());
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
			nodeElement = new ArrayList<WebElement>();
if(HTFT==true){
			// --nodule 1 home team win/lose
			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Home - Away']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Home - Away']//preceding-sibling::span")).getText());
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
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Draw - Away']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Draw - Away']//preceding-sibling::span")).getText());
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
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Away - Away']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By.xpath("//div[@class='MarketT Open']//span[text()='Half Time Full Time']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][text()='Away - Away']//preceding-sibling::span")).getText());

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
			  marketElementArray = new ArrayList<ArrayList<ArrayList<WebElement>>>();

			

			// --element 1 home team win

			element = new ArrayList<ArrayList<Double>>();
			elementElement = new ArrayList<ArrayList<WebElement>>();

			// --node 1 element 1

			node = new ArrayList<Double>();
			nodeElement = new ArrayList<WebElement>();

			// --nodule 1
			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='First Half 1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath(
						"//div[@class='MarketT Open']//span[text()='First Half 1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By
						.xpath("//div[@class='MarketT Open']//span[text()='First Half 1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span"))
						.getText());
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
			elementElement = new ArrayList<ArrayList<WebElement>>();

			// --node 1 element 2 Draw
			node = new ArrayList<Double>();
			nodeElement = new ArrayList<WebElement>();

			// --nodule 1
			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='First Half 1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(
						By.xpath("//div[@class='MarketT Open']//span[text()='First Half 1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver
						.findElement(
								By.xpath("//div[@class='MarketT Open']//span[text()='First Half 1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='']//preceding-sibling::span"))
						.getText());
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
			elementElement = new ArrayList<ArrayList<WebElement>>();

			// --node 1 element 3 Away Team Win
			
			node = new ArrayList<Double>();
			nodeElement = new ArrayList<WebElement>();
			try {
				waitLonger.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//div[@class='MarketT Open']//span[text()='First Half 1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamOne+"']//preceding-sibling::span")));

				teamOne1X2element = driver.findElement(By.xpath(
						"//div[@class='MarketT Open']//span[text()='First Half 1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamTwo+"']//preceding-sibling::span"));
				teamOne1X2 = Double.parseDouble(driver.findElement(By
						.xpath("//div[@class='MarketT Open']//span[text()='First Half 1X2']//ancestor::div[@class='MarketT Open']//span[@class='OddsL'][@title='"+teamTwo+"']//preceding-sibling::span"))
						.getText());
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
		for (int u=0;u<bets.size();){
		eventElementArray.get(bets.get(u).get(1)).get(bets.get(u).get(2)).get(bets.get(u).get(3)).get(bets.get(u).get(4)).click();}
	}

	}

	
	

	
	
	
	

	


