package old_driver_factory;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class DriverHelperOld {
	private WebDriver driver;
	private String mainWindowHandle;

	public DriverHelperOld(WebDriver driver) {
		this.driver = driver;
	}

	public void openUrl(String url) {
		driver.get(url);
		// Reporter.step.info("Navigate to : "+url);
		mainWindowHandle = driver.getWindowHandle();
	}

	public String getMainWindowhandle() {
		return mainWindowHandle;
	}

	public void waitForElementVisibility(By by, int timeOutInSeconds) {

		new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public WebElement getElement(By by, int timeOutInSeconds) {

		waitForElementVisibility(by, timeOutInSeconds);
		return driver.findElement(by);

	}

	public List<WebElement> getElements(By by, int timeOutInSeconds) {

		waitForElementVisibility(by, timeOutInSeconds);
		return driver.findElements(by);
	}

	public void click(By by, int timeOutInSeconds) {
		getElement(by, timeOutInSeconds).click();
		// Reporter.step.info("Clicked on element");

	}

	public void click(By by, int index, int timeOutInSeconds) {
		// getElements return all web elements
		// .get(index) return an object of WebElement
		getElements(by, timeOutInSeconds).get(index - 1).click();

	}

	public void sendKeys(By by, String text, int timeOutInSeconds) {
		getElement(by, timeOutInSeconds).sendKeys(text);

	}

	public String getText(By by, int timeOutInSeconds) {
		return getElement(by, timeOutInSeconds).getText().replaceAll("\\s+", " ").trim();

	}

	public void takeScreenshot() {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		// getScreenshotAs method to create image file
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);

		try {
			// Move image file to new destination
			// Copy file at destination
			FileUtils.copyFile(file, new File(System.getProperty("user.dir") + "/target/screenshots" + "/FileName "
					+ System.currentTimeMillis() + ".png"));
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void switchToNewWindow() {

		Set<String> handles = driver.getWindowHandles();
		for (String h : handles) {
			if (h.equals(mainWindowHandle)) {
				System.out.println("driver will not switch");
			} else {
				driver.switchTo().window(h);
			}
		}
	}

	public void switchToMainWindow() {

		driver.switchTo().window(mainWindowHandle);
	}

}