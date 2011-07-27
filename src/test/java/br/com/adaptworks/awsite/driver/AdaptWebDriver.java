package br.com.adaptworks.awsite.driver;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.RenderedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.com.adaptworks.awsite.bd.Usuario;

public class AdaptWebDriver implements WebDriver {

	private final WebDriver driver;

	public AdaptWebDriver(final WebDriver driver) {
		this.driver = driver;
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public void login(final Usuario user) {
		login(driver, user);

	}

	private void login(final WebDriver driver, final Usuario user) {
		driver.get("http://localhost:8088/awsite/login");

		driver.findElement(By.name("usuario.email")).sendKeys(user.getEmail());
		driver.findElement(By.name("usuario.senha")).sendKeys(user.getSenha());
		driver.findElement(By.id("login-button")).click();
	}

	public void close() {
		driver.close();
	}

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
		return !RenderedWebElement.class.isAssignableFrom(resultsDiv.getClass());
	}

	// Delegate methods to keep Java happy

	public List<WebElement> findElements(final By arg0) {
		return driver.findElements(arg0);
	}

	public void get(final String arg0) {
		driver.get(arg0);
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getWindowHandle() {
		return driver.getWindowHandle();
	}

	public Set<String> getWindowHandles() {
		return driver.getWindowHandles();
	}

	public Options manage() {
		return driver.manage();
	}

	public Navigation navigate() {
		return driver.navigate();
	}

	public void quit() {
		driver.quit();
	}

	public TargetLocator switchTo() {
		return driver.switchTo();
	}

	public boolean accessWasForbidden() {
		return driver.findElement(By.tagName("title")).getText().contains("403 Error");
	}

}
