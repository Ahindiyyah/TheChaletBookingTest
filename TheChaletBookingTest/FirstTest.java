package TheChaletBookingTest;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTest extends ParameterForTheTest {

	@BeforeTest
	public void SetUp() {
		TheSetUpOfTheWebSite();
	}

	@Test(priority = 1)
	public void TheChaletChoosingProcess() throws InterruptedException {
		ChoosingTheChalet();
	}

	@Test(priority = 2)
	public void TheItemtChoosingProcess() {
		TheItemChooingProcess();
	}

	@Test(priority = 3)
	public void SettingTheDateAndBooking() throws InterruptedException {
		SettingTheDateAndBookingprocess();
	}

	@AfterTest
	public void finish() {
		/// FinishingProcess();
	}

}
