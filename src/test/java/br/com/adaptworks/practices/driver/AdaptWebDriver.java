package br.com.adaptworks.practices.driver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.RenderedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdaptWebDriver implements WebDriver {

	private final WebDriver driver;

	public AdaptWebDriver(final WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public void close() {
		driver.close();
	}

	@Override
	public WebElement findElement(final By by) {
		return driver.findElement(by);
	}

	public WebElement lenientFindElement(final By by) {
		try {
			return findElement(by);
		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public void waitForElementToBeVisible(final By by) {
		long end = System.currentTimeMillis() + 5000;
		while (System.currentTimeMillis() < end) {
			WebElement resultsDiv = driver.findElement(by);

			if (browserDoesNotSupportJavascript(resultsDiv)) {
				return;
			}

			if (((RenderedWebElement) resultsDiv).isDisplayed()) {
				break;
			}
		}
	}

	private boolean browserDoesNotSupportJavascript(final WebElement resultsDiv) {
		return !RenderedWebElement.class
				.isAssignableFrom(resultsDiv.getClass());
	}

	// Delegate methods to keep Java happy

	@Override
	public List<WebElement> findElements(final By arg0) {
		return driver.findElements(arg0);
	}

	@Override
	public void get(final String arg0) {
		driver.get(arg0);
	}

	@Override
	public String getPageSource() {
		return driver.getPageSource();
	}

	@Override
	public String getTitle() {
		return driver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	@Override
	public Options manage() {
		return driver.manage();
	}

	@Override
	public Navigation navigate() {
		return driver.navigate();
	}

	@Override
	public void quit() {
		driver.quit();
	}

	@Override
	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public boolean accessWasForbidden() {
		return driver.findElement(By.tagName("title")).getText()
				.contains("403 Error");
	}

}
