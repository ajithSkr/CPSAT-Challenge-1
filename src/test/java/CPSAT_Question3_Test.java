import CPSAT_PageFunction.CPSAT_PageFunction;
import PageObjects.CPSAT_Question3_PageObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.Set;

public class CPSAT_Question3_Test extends CPSAT_Question3_PageObject {

    @BeforeClass
    public static void preSetup() throws IOException {
        loadWebPageFireFox(getProperties().getProperty("question3_URL"));
        implicityWait_FireFox(30L);

    }


    @Test
    public void premierLeagueWebPageTest() throws InterruptedException, IOException {

        String popUpText=searchElementByXpath_FireFox(acceptCookiesPopUp).getText();
        String closeOption=searchElementByXpath_FireFox(closeButton).getText();
        if (webDriverFireFox.getPageSource().contains(popUpText)) {
            clickElementByXpath_FireFox(acceptCookiesPopUp);
            clickElementByXpath_FireFox(closeButton);
        }
        moveElement_FireFox(premierLeagueHeader);
        clickElementByXpath_FireFox(tables);
        String sourceHandle = webDriverFireFox.getWindowHandle();
        waitForParticularTime(4L);
        if (webDriverFireFox.getPageSource().contains(popUpText)) {
            clickElementByXpath_FireFox(acceptCookiesPopUp);
            clickElementByXpath_FireFox(closeButton);
        } else if (webDriverFireFox.getPageSource().contains(closeOption)) {
            clickElementByXpath_FireFox(closeButton);
        }
        scrollToRequiredArea_FireFox(300);
        contextClick_FireFox(arsenalClub);
        waitForParticularTime(5L);
        Set<String> allWindowHandles = webDriverFireFox.getWindowHandles();
        Assert.assertTrue(allWindowHandles.size() > 1);
        String urlOfTheNewWindow = null;
        String pageTitleOfTheWindow = null;
        for (String handles : allWindowHandles) {
            if (!handles.equalsIgnoreCase(sourceHandle)) {
                webDriverFireFox.switchTo().window(handles);
                urlOfTheNewWindow = webDriverFireFox.getCurrentUrl();
                pageTitleOfTheWindow = webDriverFireFox.getTitle();
            }
        }
        System.out.println("Official webSite URL = " + urlOfTheNewWindow);
        System.out.println("Page title of newly opened window = " + pageTitleOfTheWindow);
        webDriverFireFox.switchTo().window(sourceHandle);
        waitForParticularTime(3L);
        System.out.println("Main window page title = " + webDriverFireFox.getTitle());

    }

    @AfterClass
    public static void tearDown() {
        webDriverFireFox.quit();
    }

}


