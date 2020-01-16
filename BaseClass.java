package Figosoft;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseClass {
	public WebDriver driver;
	double amprz,fkprz; //final price of both sites
	@BeforeMethod
	public void setBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:/Users/audrie/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority=1)
	public void amazon()
	{ double val=0.0d;
		driver.get("https://www.amazon.com/");
		AmazonPage a1=new AmazonPage(driver);
	    val =a1.getAmazonPrize("XR (64GB) - Yellow");  //value in $
	    amprz=a1.checkDollar(val);  //if "$" convertion rate 70.1 to INR
	    driver.quit();
		
	}
	@Test(priority=2)
	public void flipkart()
	{
			driver.get("https://www.flipkart.com/");
			FlipkartPage f1=new FlipkartPage(driver);
		    fkprz=f1.getFlipkartPrize("XR (64GB) - Yellow");
		    
			
		}
		
		@Test(priority=3)
		public void comparePriz()
		{ if(amprz<fkprz)
			System.out.println("Amazon has lower cost Rs."+ amprz);
		    else
			System.out.println("Flipkart has lower cost Rs."+ fkprz);
			
		}
		
	@AfterMethod
	public void exitApplication()
	{
		driver.quit();
	}
}
