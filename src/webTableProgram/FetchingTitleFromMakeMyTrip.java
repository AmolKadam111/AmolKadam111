package webTableProgram;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchingTitleFromMakeMyTrip {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amolk\\Documents\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.makemytrip.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//div//ul[@class='makeFlex font12']//li
		//div[@class='chHeaderContainer']//ul//li
		List<WebElement> ls = driver.findElements(By.xpath("//div//ul[@class='makeFlex font12']//li"));
		   for(int i=0;i<ls.size();i++) {
		System.out.println(ls.get(i).getText());
	}
		   driver.quit();
	}

	
}
