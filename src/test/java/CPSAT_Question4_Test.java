import PageObjects.CPSAT_Question4_PageObject;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CPSAT_Question4_Test extends CPSAT_Question4_PageObject {


    @BeforeClass
    public static void preSetup() throws IOException {
        loadWebPageFireFox(getProperties().getProperty("question4_URL"));
        implicityWait_FireFox(30L);
    }

    @Test
    public void testHomeTownPage() throws InterruptedException {
        waitUntilTheElementIsVisible_FireFox(4L, noThanksPopUpButton);
        clickElementByXpath_FireFox(noThanksPopUpButton);
        waitForParticularTime(4L);
        waitUntilTheElementIsClickable_FireFox(4L, electronicsOption);
        clickElementByXpath_FireFox(electronicsOption);
        moveElement_FireFox(appliedFiltersTab);
        waitForParticularTime(3L);
        moveElement_FireFox(colorDropDownMenu);
        waitForParticularTime(3L);
        clickElementByXpath_FireFox(blackColor);
        waitForParticularTime(2L);
        moveElement_FireFox(productImage);
        waitForParticularTime(2L);
        clickElementByXpath_FireFox(quickViewOption);
        Assert.assertTrue(searchElementByXpath_FireFox(imageTitle).getText().toLowerCase().contains("black"));
        List<String> appliedFiltersElements=new LinkedList<String>();
        for(int i=0;i<searchElementsByXpath_FireFox(appliedFilters).size();i++)
        {
            appliedFiltersElements.add(searchElementsByXpath_FireFox(appliedFilters).get(i).getText());
        }
        Assert.assertTrue(appliedFiltersElements.contains("Black"));

    }

    @AfterClass
    public static void tearDown() {
        webDriverFireFox.quit();
    }
}
