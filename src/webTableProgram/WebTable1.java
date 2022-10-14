package webTableProgram;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable1 {

	public static void main(String[] args) throws InterruptedException, IOException {

//		System.setProperty("webdriver.gecko.driver","C:\\Users\\amolk\\Documents\\geckodriver-v0.31.0-win64\\geckodriver.exe");
//		
//		WebDriver driver1 = new FirefoxDriver ();

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\amolk\\Documents\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		int rows = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr")).size();
		System.out.println("No. of rows -"+rows);

		int columns = driver.findElements(By.xpath("//table[@id='customers']//tbody//tr[2]/td")).size();
		System.out.println("No. of Columns -"+columns);
		
		for (int i =1;i<=columns;i++) {
			String value = driver
					.findElement(By.xpath("//table[@id='customers']//tbody//tr[1]/th["+i+"]"))
					.getText();
			System.out.print(value +"               ");
		}
		System.out.println();

		for (int r = 2; r <=rows; r++) {
			for (int c = 1; c <= columns; c++) {
				String value = driver
						.findElement(By.xpath("//table[@id='customers']//tbody//tr["+r+"]/td["+c+"]"))
						.getText();
				System.out.print(value + "               ");
			}
			System.out.println();

		}
		driver.quit();
	}
}
