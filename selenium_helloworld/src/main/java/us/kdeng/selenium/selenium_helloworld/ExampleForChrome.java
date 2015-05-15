package us.kdeng.selenium.selenium_helloworld;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

// http://www.open-open.com/lib/view/1354764154148

public class ExampleForChrome {
	public static void main(String[] argv) throws IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
		
		ChromeDriverService chromeService = new ChromeDriverService.Builder().usingDriverExecutable(
                        new File("C:\\DevTools\\SeleniumWebDriver\\chromedriver.exe")).usingAnyFreePort().build();
		chromeService.start();
		
		WebDriver driver = new RemoteWebDriver(chromeService.getUrl(), DesiredCapabilities.chrome());
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
		
		chromeService.stop();
	}
}
