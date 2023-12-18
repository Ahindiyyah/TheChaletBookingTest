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

public class ParameterForTheTest {
	WebDriver driver = new ChromeDriver();
	String WebSite = "https://www.almosafer.com/ar?ncr=1";
	Random rand = new Random();

	public void TheSetUpOfTheWebSite() {
		driver.get(WebSite);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	public void ChoosingTheChalet() throws InterruptedException {
		WebElement chaletsTab = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-chalets\"]/div"));
		chaletsTab.click();
		WebElement chaletNameInput = driver.findElement(
				By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-chalets\"]/div/section/div/form/div[1]/input"));
		chaletNameInput.click();
		WebElement madinaOption = driver.findElement(By.xpath(
				"//*[@id=\"uncontrolled-tab-example-tabpane-chalets\"]/div/section/div/form/div[1]/div[2]/div/div/div/button[7]/span[1]"));
		madinaOption.click();
		Thread.sleep(2000);
		WebElement Button = driver.findElement(
				By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-chalets\"]/div/section/div/form/button"));
		Button.click();
	}

	public void TheItemChooingProcess() {
		WebElement SecondElement = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[2]/div[2]/a/div/div[2]/div/div[2]"));
		SecondElement.click();
	}

	public void SettingTheDateAndBookingprocess() throws InterruptedException {
		Thread.sleep(4000);
		WebElement checkInDate = driver
				.findElement(By.xpath("//*[@id=\"js-C2CGuestSearchBoxDatePickerCheckInDate\"]/span"));
		checkInDate.click();
		List<WebElement> TheDates = driver.findElements(By.cssSelector("[role='gridcell']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		for (int i = 0; i < 2;) {
			int RandomIndex = rand.nextInt(TheDates.size());
			WebElement TheChoosenDate = TheDates.get(RandomIndex);
			if (i == 0 && !TheChoosenDate.getAttribute("class").contains("DayPicker-Day--blocked")) {
				TheChoosenDate.click();
				i++;
			} else if (i == 1 && !TheChoosenDate.getAttribute("class").contains("DayPicker-Day--disabled")
					&& !TheChoosenDate.getAttribute("class").contains("DayPicker-Day--blocked")) {
				TheChoosenDate.click();
				i++;
			} else {
				System.out.println("this element cant be added");
			}
		}
		Thread.sleep(2000);
		WebElement entranceTime = driver.findElement(
				By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/div/div[1]/div[3]/div"));
		boolean isEntranceTimeDisplayed = entranceTime.isDisplayed();
		WebElement bookNowButton = driver
				.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[2]/div[2]/button/div"));
		boolean isBookNowButtonDisplayed = bookNowButton.isDisplayed();
		Assert.assertEquals(isEntranceTimeDisplayed, true);
		Assert.assertEquals(isBookNowButtonDisplayed, true);
		Thread.sleep(2000);
		WebElement BookNow = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div[2]/div[2]/div[2]/button"));
		BookNow.click();
	}

	public void FinishingProcess() {
		// driver.close();
	}
}
