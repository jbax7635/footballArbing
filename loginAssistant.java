
public class loginAssistant extends Thread{
	
public driver driver;
	public loginAssistant(driver driver1) {
		// TODO Auto-generated constructor stub
		driver=driver1;
	}
	public void run(){
		driver.login();
		
	}

}
