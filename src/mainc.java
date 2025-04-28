import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class mainc {
	
	
	
	public static void main(String args[]) throws IOException, InterruptedException
	{
		String green="\\u001B";
		
		System.setProperty("webdriver.chrome.driver","driver\\chromedriver.exe");
		
		
		File file= new File("config\\vtnfconfig.properties");
		
		Properties prop= new Properties();
		
		FileInputStream fis= new FileInputStream(file);
		
		prop.load(fis);
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		System.out.println(prop.getProperty("url"));
		
		driver.get(prop.getProperty("url"));
		
		WebElement email= driver.findElement(By.id("inputEmail"));
		
		String inputemail= prop.getProperty("email");
		
		email.sendKeys(inputemail);
		
		WebElement password= driver.findElement(By.id("inputPassword"));
		
		String Email = prop.getProperty("adminpassword");
		
		password.sendKeys(Email);
		
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
		Thread.sleep(10000);
		
		String String = "Data Envoy Home";
		
		
		if(driver.getPageSource().contains(String))
			
		{
			System.out.println( "You LoggedIn Successfully");
		}
		else
		{
			
			System.out.println("Not LoggedIn.");
		}
		
		
		List<WebElement> elements= driver.findElements(By.tagName("a"));
		
		int totalhyperlinks = elements.size();
		
		System.out.println("Total Hyperliks are " +totalhyperlinks);
		
		for(int i=0;i<totalhyperlinks;i++)
		{
			boolean b = elements.get(i).isEnabled();
			
			//System.out.println(b);
			
		    if(b=true)
			{
				System.out.println( "\u001B[32m Element" +elements.get(i).getText() +" is clikable");
			}
			else
			{
				System.out.println("Element is not clickable");
			}
			
			

		}
		
				
		
	}
	
	
	
	
	
}
