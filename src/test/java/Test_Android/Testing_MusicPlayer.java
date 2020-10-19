package Test_Android;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Testing_MusicPlayer {
	
	static AppiumDriver<MobileElement> driver;
	
	public static void main(String[] args) {
		
		try {
			
			setUp();
		} catch (Exception e) {
			// TODO: handle exception
			
			System.out.print(e.getCause());
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		
	}
	@BeforeClass
	public static void setUp() throws MalformedURLException{
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","PRA LA1");
		capabilities.setCapability("udid","PSE7N17921003814");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","8.0.0");
		capabilities.setCapability("appPackage","com.instantappsample.uamp");
		capabilities.setCapability("appActivity","com.example.android.uamp.ui.MusicPlayerActivity");
		//capabilities.setCapability("appActivity1","com.example.android.uamp.ui.PlaceholderActivity");
		//capabilities.setCapability("appActivity2","com.example.android.uamp.ui.NowPlayingActivity");
		//capabilities.setCapability("appActivity3","com.example.android.uamp.ui..tv.TVBrowseActivity");
		//capabilities.setCapability("appActivity4","com.example.android.uamp.ui.tv.TVVerticalGridActivity");
		//capabilities.setCapability("appActivity5","com.example.android.uamp.ui.tv.TVPlaybackActivity");
		//capabilities.setCapability("appActivity6","com.example.android.uamp.ui.FullScreenPlayerActivity");
		//capabilities.setCapability("appActivity7","com.google.android.gms.common.api.GoogleApiActivity");
		//capabilities.setCapability("appActivity8","com.example.android.uamp.ui.MusicService");
		//capabilities.setCapability("appActivity9","com.google.android.gms.cast.framework.media.MediaNotificationService");
		//capabilities.setCapability("appActivity10","com.google.android.gms.cast.framework.ReconnectionService");
	
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url,capabilities);
		
		System.out.println("Application started....");
	}

	@Test
	public void testCal() throws Exception {
		//locating elements and click
		MobileElement menu=driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc=\"Open the main menu\"]"));
		menu.click();
		MobileElement AllMusic=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.support.v7.widget.LinearLayoutCompat[1]/android.widget.CheckedTextView"));
		AllMusic.click();
		
		MobileElement Genres=driver.findElement(By.id("com.instantappsample.uamp:id/description"));
		
		Genres.click();
		
	}

	@AfterClass
	public void teardown(){
		//close the app
		driver.quit();
	}
}