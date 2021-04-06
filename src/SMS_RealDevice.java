import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SMS_RealDevice {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
      
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability(MobileCapabilityType.PLATFORM_VERSION, "5.1.1");
		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");
		dc.setCapability("appPackage", "com.android.mms");
		dc.setCapability("appActivity", "com.android.mms.ui.ComposeMessageActivity");
        
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url, dc);
		
		driver.findElement(By.id("com.android.mms:id/recipients_editor")).click();
		driver.findElement(By.id("com.android.mms:id/recipients_editor")).sendKeys("9410435903");
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.mms:id/embedded_text_editor")).click();
		driver.findElement(By.id("com.android.mms:id/embedded_text_editor")).sendKeys("Appium automation testing");
		Thread.sleep(3000);
		driver.findElement(By.id("com.android.mms:id/send_button")).click();
		Thread.sleep(3000);
		String message = driver.findElement(By.id("android:id/message")).getText();
		System.out.println(message);
		if(message.contains("No SIM")) 
		{
			System.out.println("Test Passed ....");
		}else 
		{
			System.out.println("Test Failed ....");
		}
		Thread.sleep(5000);
		driver.findElement(By.id("android:id/button1")).click();;
		driver.quit();
		
		
		
		
		
		
	}

}
