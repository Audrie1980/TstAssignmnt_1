/**
 * 
 */
package Figosoft;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author audrie
 *
 */
public class FlipkartPage {
	WebDriver driver;
	 
	By srchbox=By.cssSelector("input.LM6RPg");
	By srchbtn=By.cssSelector("button.vh79eN");
	By price= By.cssSelector("div._1vC4OE._2rQ-NK");
	By closepop=By.cssSelector(".\\_29YdH8");
	FlipkartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public int getFlipkartPrize(String phname)
	{boolean pop=true;
	WebElement clswin=driver.findElement(closepop);
		Pattern p=Pattern.compile("\\d+");    //Rs currency
	    String st2="";String st3="";
	    pop= clswin.isDisplayed();
		if(pop==true)
			clswin.click();
		driver.findElement(srchbox).sendKeys(phname);
		
		driver.findElement(srchbtn).click();
		String st1=driver.findElement(price).getText();
		Matcher m=p.matcher(st1);
		while(m.find())             //extract num from Rs currency
		{st2=m.group();
		st3=st3+st2;
		st2="";}
	    int value = Integer.parseInt(st3);
	    System.out.println(value+"flipkart op"+st3);
	    return value;
	}
   
}


