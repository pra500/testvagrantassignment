package com.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	// this class has been used for initializing the browser

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {

		try {
			prop = new Properties();
			FileInputStream fip = new FileInputStream(
					"C:\\Users\\dell\\eclipse-workspace\\Testvagrant\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fip);

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	// initializing the browser
	public static void initialization() {
		String browsername = prop.getProperty("browser");

		if (browsername.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		/*
		 * else if(browsername.equalsIgnoreCase("ie"));
		 * 
		 * {
		 * 
		 * WebDriverManager.iedriver().setup(); driver = new InternetExplorerDriver();
		 * 
		 * }
		 */

		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		
	}

}
