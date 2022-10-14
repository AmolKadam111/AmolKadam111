package webTableProgram;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkOnWebPage2 {
	
	static int a;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\amolk\\Documents\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
	    WebDriver driver=new ChromeDriver();
	    
	    driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summery.html");
	    
	    driver.manage().window().maximize();
	    
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
	    //firstly capture all links
	    List<WebElement> links = driver.findElements(By.tagName("a"));
	    
	    System.out.println(links.size());
	    
	    for(int i=0;i<links.size();i++) {
	    	
	    	WebElement element = links.get(i);
	    	
	    	//using href attribute we can get url of required link
	    	String url=element.getAttribute("href");
	    	
	    	//create an object  of URL class
	    	URL link=new URL(url);
	    	
	    	//HttpURLConnection class used for check whether link is connecting target page or not
	    	//now to create connection using URL object
	    	HttpURLConnection httpConn=(HttpURLConnection)link.openConnection();
	    	
	    	Thread.sleep(2000); // wait because it take time to establish connection
	    	
	    	httpConn.connect();
	    	
	    	//now to get response code=>if response code is above 400 then it is a broken link
	    	int respCode=httpConn.getResponseCode();
	    	
	    	if(respCode>=400) {
	    		a++;
	    		System.out.println(url+"_"+"broken link");
	    	}
	    	else {
	    		System.out.println(url+" "+"valid link");
	    	}
	    	
	    }
	    System.out.println("Total Broken Links are- "+a);
	    driver.quit();
	    
	    
	
	}

}
