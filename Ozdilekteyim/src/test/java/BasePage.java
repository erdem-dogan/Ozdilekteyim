import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class BasePage extends BaseTest {

    WebDriverWait wait;

    public MobileElement findElement(By locator){
        return appiumDriver.findElement(locator);
    }

    public List<MobileElement> findElements(By locator){
        return appiumDriver.findElements(locator);
    }

    public void clickElement(By locator) {
        findElement(locator).click();
    }

    public void wait(int i, By locator){
        wait = new WebDriverWait(appiumDriver, i);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void scrollDown(String value){
        appiumDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd("+value+")"));
    }

    public void selectRandom(By locator){
        List<MobileElement> elements = findElements(locator);
        elements.get(new Random().nextInt(elements.size())).click();
    }

    public void sendKeys(By locator, String value){
        appiumDriver.findElement(locator).sendKeys(value);
    }

    public void assertion(By locator){
        Assert.assertTrue(appiumDriver.findElement(locator).isDisplayed());
    }

}
