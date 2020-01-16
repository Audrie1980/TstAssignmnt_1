/**
 * 
 */
package Figosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author audrie
 *
 */
public class AmazonPage {
	WebDriver driver;
	 
	By srchbox=By.id("twotabsearchtextbox");
	By srchbtn=By.cssSelector("input.nav-input");
	By pricew= By.cssSelector("span.a-price-whole");
	By pricef= By.cssSelector("span.a-price-fraction");
	By dollar=By.cssSelector("span.a-price-symbol");
	AmazonPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public double getAmazonPrize(String phname)
	{
		driver.findElement(srchbox).sendKeys(phname);
		driver.findElement(srchbtn).click();
		String st1=driver.findElement(pricew).getText();
		String st2=driver.findElement(pricef).getText();
		System.out.println("amaxon op11"+st1);//remove dollar
		//st1=st1.replaceAll("$", "");   
		System.out.println("amaxon opdeci "+st2);//remove dollar
	    double value = Double.parseDouble(st1);
	    double value1 = Double.parseDouble(st2);
	    value1=value1/100;
	   
	    value=value+value1;
	    System.out.println(value+"amaxon op fial"+st1);
	    return value;
	}
	public double checkDollar(double val)
	{ double d;
		String st1=driver.findElement(dollar).getText();
	  if(st1.equals("$"))// INR=70
		d=val*70.1;
		else
		d=val;
	  return d;
	}

}
