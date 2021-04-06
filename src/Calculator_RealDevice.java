import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Calculator_RealDevice {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
        
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability("appPackage", "com.android.calculator2");
		dc.setCapability("appActivity", "com.android.calculator2.Calculator");
        
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, dc);
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.calculator2:id/guide_week_img2")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.calculator2:id/digit7")).click();
		driver.findElement(By.id("com.android.calculator2:id/plus")).click();
		driver.findElement(By.id("com.android.calculator2:id/digit6")).click();
		
		driver.findElement(By.id("com.android.calculator2:id/equal")).click();
		Thread.sleep(5000);
		String result = driver.findElement(By.id("com.android.calculator2:id/edittext")).getText();
		System.out.println(result);
		String [] r = result.split("=");
		String first = r[0];
		String second = r[1];
		System.out.println(first+second);
		if(second.equals("13")) 
		{
			System.out.println("Test Passed ....");
		}else 
		{
			System.out.println("Test Failed ....");
		}
		Thread.sleep(5000);
		driver.quit();
		
	}

}
   