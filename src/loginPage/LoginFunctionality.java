package loginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFunctionality {
	
	@Test(dataProvider  = "methodTwo")
	public void methodOne(String username, String password) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\ChromeDriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("http://3.124.205.97/admin");
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys(username);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(3000);
			String title = driver.getCurrentUrl();
			//http://3.124.205.97/dashboard
			Assert.assertTrue(driver.getCurrentUrl().equals("http://3.124.205.97/dashboard"));
		
	}
	@DataProvider
	public String[][] methodTwo() {	
    	String [][]ar = new String[3][2];
    	ar[0][0] = (" ");
    	ar[0][1] = (" ");
    	ar[0][0] = ("admin@gmail.com");
    	ar[0][1] = ("123456");
    	ar[2][0] = ("admin@gmail.com");
    	ar[2][1] = ("admin123456");
    	return ar;
    }

}
