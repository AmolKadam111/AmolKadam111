package webTableProgram;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IframesAndFrames {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\amolk\\Documents\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summery.html");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.quit();
		
		
		
	}

}
