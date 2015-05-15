package us.kdeng.selenium.selenium_helloworld;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// http://www.open-open.com/lib/view/1354764154148
// IE -> Tools -> Security tab, check Enable Protected Mode checkbox for all zones
// Change Zoom 100%

public class ExampleForIE {
	public static void main(String[] argv) {
		File file = new File("C:/DevTools/SeleniumWebDriver/IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver", file.getAbsolutePath());	
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("http://www.google.com");
		System.out.println("1 Page title is: " + driver.getTitle());
		
		WebDriverWait wait = new WebDriverWait(driver, 4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.name("q"))));
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("neu");
		element.submit();
		
		(new WebDriverWait(driver, 3)).until(
			new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	                return d.getTitle().toLowerCase().startsWith("neu");
	            }
			}
		);
		
		System.out.println("2 Page title is: " + driver.getTitle());
		
		driver.quit();
	}
}
