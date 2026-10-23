import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.latest.page.model.Screenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class firstTest {

	public static void main(String[] args) throws IOException {
	
       WebDriver driver =new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.get("https://www.google.com/");
       driver.navigate().to("https://www.amazon.com/");
       System.out.println(driver.getCurrentUrl());
       System.out.println(driver.getTitle());
       String originalWindow=driver.getWindowHandle();
       driver.switchTo().window(originalWindow);
       driver.switchTo().newWindow(WindowType.WINDOW);
       driver.switchTo().newWindow(WindowType.TAB);
       Dimension size=driver.manage().window().getSize();
       System.out.println(size.getWidth());
       System.out.println(size.getHeight());
       File srcfile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       
       FileUtils.copyFile(srcfile, new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumProject\\src\\test\\java\\screenshot.png"));
       
       driver.close();
       
	}

}
